package logic;

import exceptions.NonUniqueIdException;
import exceptions.StartingProblemException;



public class Launcher {

    public static void main(String[] args) {
        try (JsonHandler handler = new JsonHandler(args[0]);
             CliDevice cio = new CliDevice()) {
            Manager manager = new Manager(handler.readCollection());
            Service app = new ConsoleService(cio, manager, handler);
            app.start();
        } catch (StartingProblemException | NonUniqueIdException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо передать название файла в аргументах");
        }
    }
}
