import javax.swing.*;

public class Main {
    static String mainButtonsNames[] = {
        "Create a new list",
        "Edit an entry",
        "Search",
        "View full DB"
    };

    private static int width = 500;
    private static int height = 500;
    private static JFrame frame = new JFrame("Hotelbd");
    private static Task taskManager = new Task(frame, 10);
    private static HotelList HotelPack;
    

    public static void main(String args[]){ //main menu
        mainMenu();
    }
    private static void mainMenu(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setLayout(null);

        JPanel mainMenu = new JPanel();
        mainMenu.setBounds(0,0,width,height);
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
            "Done",
            "View field"
        };
        Person PersonTempBuff[] = new Person[10];
        final int[] PersonTempBuffPtr = {0};

        JPanel listRedactorPanel = new JPanel();
        taskManager.addTask(listRedactorPanel);
        taskManager.getTask().setBounds(0,0,width, height);
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
                button.setLocation(width/2 - 100, height-50);
            }
            else if (listRedactorButtonsParser == "View field"){
                button.setSize(60, 10);
                button.setLocation(width - 100, height-50);
            }
            else{
                button.setSize(200,50);
                button.setLocation(100, 50+step*50);
            }
            if(listRedactorButtonsParser == "Done"){
                button.addActionListener(e -> {
                    

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
            if (listRedactorButtonsParser == "View field"){
                button.addActionListener(e ->{

                });
            }
            step++;
            taskManager.getTask().add(button);
        }

        int yPosition = 10;
        int jump = 25;

        JTextField idField = new JTextField();
        idField.setBounds(150, yPosition, 200, 25);
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(idLabel);
        taskManager.getTask().add(idField);
        yPosition += jump;
        
        JTextField hostelNameField = new JTextField();
        hostelNameField.setBounds(150, yPosition, 200, 25);
        JLabel hostelNameLabel = new JLabel("Hotel Name:");
        hostelNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(hostelNameLabel);
        taskManager.getTask().add(hostelNameField);
        yPosition += jump;

        JTextField cityNameField = new JTextField();
        cityNameField.setBounds(150, yPosition, 200, 25);
        JLabel cityNameLabel = new JLabel("City:");
        cityNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(cityNameLabel);
        taskManager.getTask().add(cityNameField);
        yPosition += jump;

        JTextField streetNameField = new JTextField();
        streetNameField.setBounds(150, yPosition, 200, 25);
        JLabel streetNameLabel = new JLabel("St. name:");
        streetNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(streetNameLabel);
        taskManager.getTask().add(streetNameField);
        yPosition += jump;

        JTextField streetNumberField = new JTextField();
        streetNumberField.setBounds(150, yPosition, 200, 25);
        JLabel streetNumberLabel = new JLabel("St. number:");
        streetNumberLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(streetNumberLabel);
        taskManager.getTask().add(streetNumberField);
        yPosition += jump;

        JTextField houseNumberField = new JTextField();
        houseNumberField.setBounds(150, yPosition, 200, 25);
        JLabel houseNumberLabel = new JLabel("House number:");
        houseNumberLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(houseNumberLabel);
        taskManager.getTask().add(houseNumberField);
        yPosition += jump;

        JTextField doorNumberField = new JTextField();
        doorNumberField.setBounds(150, yPosition, 200, 25);
        JLabel doorNumberLabel = new JLabel("Door number:");
        doorNumberLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(doorNumberLabel);
        taskManager.getTask().add(doorNumberField);
        yPosition += jump;

        JTextField PersonFNameField = new JTextField();
        PersonFNameField.setBounds(150, yPosition, 200, 25);
        JLabel PersonFNameLabel = new JLabel("Person 1th Name:");
        PersonFNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(PersonFNameLabel);
        taskManager.getTask().add(PersonFNameField);
        yPosition += jump;

        JTextField PersonSNameField = new JTextField();
        PersonSNameField.setBounds(150, yPosition, 200, 25);
        JLabel PersonSNameLabel = new JLabel("Person 2th Name:");
        PersonSNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(PersonSNameLabel);
        taskManager.getTask().add(PersonSNameField);
        yPosition += jump;

        JTextField PersonMNameField = new JTextField();
        PersonMNameField.setBounds(150, yPosition, 200, 25);
        JLabel PersonMNameLabel = new JLabel("Person mid Name:");
        PersonMNameLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(PersonMNameLabel);
        taskManager.getTask().add(PersonMNameField);
        yPosition += jump;

        JTextField PersonPhoneNumberField = new JTextField();
        PersonPhoneNumberField.setBounds(150, yPosition, 200, 25);
        JLabel PersonPhoneNumberLabel = new JLabel("Person ph number:");
        PersonPhoneNumberLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(PersonPhoneNumberLabel);
        taskManager.getTask().add(PersonPhoneNumberField);
        yPosition += jump;

        JTextField PersonPostField = new JTextField();
        PersonPostField.setBounds(150, yPosition, 200, 25);
        JLabel PersonPostLabel = new JLabel("Person post:");
        PersonPostLabel.setBounds(50, yPosition, 100, 25);
        taskManager.getTask().add(PersonPostLabel);
        taskManager.getTask().add(PersonPostField);
        yPosition += jump;

        JButton addPersonToArray = new JButton("Add person");
        addPersonToArray.setSize(70, 20);
        addPersonToArray.setLocation(width/2-70/2, yPosition);
        addPersonToArray.addActionListener(e->{

            PersonTempBuff[PersonTempBuffPtr[0]%10] = new Person();

            PersonTempBuff[PersonTempBuffPtr[0]%10].firstName = PersonFNameField.getText().trim().isEmpty() ? "null" : PersonFNameField.getText().trim();
            PersonTempBuff[PersonTempBuffPtr[0]%10].secondName = PersonSNameField.getText().trim().isEmpty() ? "null" : PersonSNameField.getText().trim();
            PersonTempBuff[PersonTempBuffPtr[0]%10].middleName = PersonMNameField.getText().trim().isEmpty() ? "null" : PersonMNameField.getText().trim();
            PersonTempBuff[PersonTempBuffPtr[0]%10].phoneNumber = PersonPhoneNumberField.getText().trim().isEmpty() ? "null" : PersonPhoneNumberField.getText().trim();
            PersonTempBuff[PersonTempBuffPtr[0]%10].post = PersonPostField.getText().trim().isEmpty() ? "null" : PersonPostField.getText().trim();
            
            System.out.println(
                     PersonTempBuff[PersonTempBuffPtr[0]%10].firstName +
                "\n"+PersonTempBuff[PersonTempBuffPtr[0]%10].secondName+
                "\n"+PersonTempBuff[PersonTempBuffPtr[0]%10].middleName+
                "\n"+PersonTempBuff[PersonTempBuffPtr[0]%10].phoneNumber+
                "\n"+PersonTempBuff[PersonTempBuffPtr[0]%10].post
            );

            HotelPack = new HotelList();
            

            PersonFNameField.setText("");
            PersonSNameField.setText("");
            PersonMNameField.setText("");
            PersonPhoneNumberField.setText("");
            PersonPostField.setText("");

            PersonTempBuffPtr[0]++;
        });
        yPosition+=jump;

        taskManager.getTask().add(addPersonToArray);
        
        frame.add(taskManager.getTask());
    }
}
