package logic;

import annotations.Builder;
import resources.Messages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.TreeSet;

public class CliDevice extends IODevice {

    public CliDevice() {
        super(new Scanner(System.in));
    }

    @Override
    public <T> T readElement(T base) {
        TreeSet<Method> methods = selectMethods(base.getClass().getMethods());
        for (Method method : methods) {
            Builder annotation = method.getAnnotation(Builder.class);
            Class<?> type = method.getParameterTypes()[0];
            while (true) {
                try {
                    if (type != String.class) {
                        method.invoke(base, readElement(type.getConstructor().newInstance()));
                    } else {
                        System.out.printf(getQuery(annotation));
                        String field = input.nextLine();
                        method.invoke(base, field);
                    }
                    break;
                } catch (InvocationTargetException e) {
                    System.out.println(e.getCause().getMessage());
                } catch (IllegalAccessException | NoSuchMethodException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return base;
    }


    private String getQuery(Builder annotation) {
        StringBuilder query = new StringBuilder(Messages.getMessage("input.format.parameter", Messages.getMessage(annotation.field())));
        if (annotation.variants().length != 0) {
            query.append(" ").append(Messages.getMessage("input.from_list")).append("\n");
            for (int i = 0; i < annotation.variants().length; ++i) {
                query.append(String.format("%s. %s\n", i + 1, Messages.getMessage(annotation.variants()[i])));
            }
        } else {
            query.append(":\n");
        }
        return query.toString();
    }

}
