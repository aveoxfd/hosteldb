import javax.swing.*;

public class Main {
    static String mainButtonsNames[] = {
        "Create a new list",
        "Edit an entry",
        "Search",
        "View full DB"
    };

    static JFrame frame = new JFrame("Hostelbd");
    static Task taskManager = new Task(frame, 10);
    

    public static void main(String args[]){ //main menu
        mainMenu();
    }
    private static void mainMenu(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setLayout(null);

        JPanel mainMenu = new JPanel();
        mainMenu.setBounds(0,0,400,400);
        mainMenu.setLayout(null);
        mainMenu.setVisible(true);
        taskManager.addTask(mainMenu);
        frame.add(taskManager.getTask());



        int step = 0;
        for (String mainMenuButtonNames : mainButtonsNames){
            JButton button = new JButton(mainMenuButtonNames);
            button.setSize(200,50);
            button.setLocation(100, 50+step*50);

            if(mainMenuButtonNames=="Create a new list"){
                button.addActionListener(e -> {
                    taskManager.getTask().setVisible(false);
                    listRedactor();
                });
            }
            else if(mainMenuButtonNames=="Search"){
                button.addActionListener(e -> {
                    searchRoom();
                });
            }
            else if(mainMenuButtonNames=="View full information"){
                button.addActionListener(e -> {
                    //TODO
                });
            }
            else if (mainMenuButtonNames=="Edit an entry"){
                button.addActionListener(e -> {
                    //TODO
                });
            }

            step++;
            taskManager.getTask().add(button);
        }
    }
    private static void searchRoom(){
        System.out.println("Search opened");
        System.out.println(taskManager.getTaskCount());
        //TODO
    }
    private static void listRedactor(){
        String listRedactorButtons[] = {
            "<-",
            "Done"
        };

        JPanel listRedactorPanel = new JPanel();
        taskManager.addTask(listRedactorPanel);
        taskManager.getTask().setBounds(0,0,400, 400);
        taskManager.getTask().setLayout(null);
        taskManager.getTask().setVisible(true);

        int step = 0;
        for (String listRedactorButtonsParser : listRedactorButtons){
            JButton button = new JButton(listRedactorButtonsParser);
            if(listRedactorButtonsParser == "<-"){
                button.setSize(45, 20);
                button.setLocation(0, 0);
            }
            else if (listRedactorButtonsParser == "Done"){
                button.setSize(200, 10);
                button.setLocation(100, 350);
            }
            else{
                button.setSize(200,50);
                button.setLocation(100, 50+step*50);
            }
            if(listRedactorButtonsParser == "Done"){
                button.addActionListener(e -> {
                    System.out.println("Done");

                    taskManager.getTask().setVisible(false);
                    taskManager.removeTask();
                    mainMenu();
                });
            }
            if (listRedactorButtonsParser == "<-"){
                button.addActionListener(e -> {
                    taskManager.getTask().setVisible(false);
                    taskManager.removeTask();
                    mainMenu();
                });
            }
            step++;
            taskManager.getTask().add(button);
        }
        JTextField hostelNameField = new JTextField("Test");
        hostelNameField.setSize(200,30);
        hostelNameField.setLocation(100,50);
        //TODO
        taskManager.getTask().add(hostelNameField);
        frame.add(taskManager.getTask());
    }
}
