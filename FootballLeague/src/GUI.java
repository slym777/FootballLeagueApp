import database.ManagerDatabase;
import database.PlayerDatabase;
import database.RefereeDatabase;
import org.jdesktop.swingx.JXDatePicker;
import persons.Manager;
import persons.Player;
import persons.Referee;
import services.FootballLeagueService;
import services.PersonsService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class GUI {

    public GUI(){

        JFrame frame = new JFrame("Football League App");

        createPage1();
        createPage2();
        createPage3();

        jTabbedPane1.addTab("Football League", jPanel1);
        jTabbedPane1.addTab("Leaderboard", jPanel2);
        jTabbedPane1.addTab("Edit", jPanel3);

        new DigitalWatch();
        frame.add(jTabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(b, BorderLayout.PAGE_END);
//        frame.setLocation(
//                (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2,
//                (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2
//
//        );
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.pack();
    }


    private void createPage1() {
//        displayLeague();

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        modifyLeague = new javax.swing.JButton();
        loading = new javax.swing.JLabel();
        ScrollTeams = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        ScrollManagers = new javax.swing.JScrollPane();
        showTeam = new javax.swing.JButton();
        deletePlayer = new javax.swing.JButton();
        deleteManager = new javax.swing.JButton();
        insertPerson = new javax.swing.JButton();
        deleteReferee = new javax.swing.JButton();
        insertScorBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TeamScorL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ScrollPlayers = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        ScrollTable = new javax.swing.JScrollPane();
        addWeek = new javax.swing.JButton();

        jLabel2.setIcon(new ImageIcon("Premier_League_Logo.svg.png")); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Premiere League Football Clubs");


        DefaultListModel clubsNames = new DefaultListModel();
        for (String name: FootballLeagueService.getClubsNames())
            clubsNames.addElement(name);
        TeamList = new JList(clubsNames);
        TeamList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        TeamList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TeamList.setToolTipText("Choose a Team");
        ScrollTeams.setViewportView(TeamList);
        ScrollTeams.createVerticalScrollBar();

        showTeam.setForeground(new java.awt.Color(255, 51, 51));
        showTeam.setText("Show");
        showTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                removeTeamActionPerformed(evt);
            }
        });

        modifyLeague.setText("Change League");
        modifyLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        loading.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(ScrollTeams)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addComponent(jLabel4)
                                                        .addComponent(showTeam))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(modifyLeague))))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(loading))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(modifyLeague)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addContainerGap(46, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(ScrollTeams)
                                                .addComponent(showTeam)
                                                .addGap(18, 18, 18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loading))))
        );

    }

    private void createPage2(){
        jPanel2 = new JPanel();
        jPanel2.setLayout(null);

        ScrollTable = new JScrollPane();
        LeagueTable = new JTable();
        displayLeague("points");
        ScrollTable.setViewportView(LeagueTable);
        ScrollTable.setBounds(50, 120, 700,500);

        JButton points = new JButton();
        points.setText("Points");
        points.setBounds(30, 20, 100,40);
        points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("points");
            }
        });

        JButton wins = new JButton();
        wins.setText("Wins");
        wins.setBounds(155, 20, 100,40);
        wins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("wins");
            }
        });


        JButton loses = new JButton();
        loses.setText("Loses");
        loses.setBounds(280, 20, 100,40);
        loses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("loses");
            }
        });

        JButton scoredG = new JButton();
        scoredG.setText("Scored G");
        scoredG.setBounds(405, 20, 100,40);
        scoredG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("scoredg");
            }
        });

        JButton receivedG = new JButton();
        receivedG.setText("Recieved G");
        receivedG.setBounds(530, 20, 100,40);
        receivedG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("receivedg");
            }
        });

        JButton goalDif = new JButton();
        goalDif.setText("Goal +/-");
        goalDif.setBounds(655, 20, 100,40);
        goalDif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeague("goaldiff");
            }
        });

        jPanel2.add(ScrollTable);
        jPanel2.add(points);
        jPanel2.add(wins);
        jPanel2.add(loses);
        jPanel2.add(scoredG);
        jPanel2.add(receivedG);
        jPanel2.add(goalDif);
    }

    private void displayLeague(String sort){
        String columns[] = {"Nr", "Club", "Games", "Wins", "Draws", "Loses", "SGoals", "RGoals", "GoalDiff", "Points"};
        switch (sort){
            case "points":
                FootballLeagueService.sortByPoints();
                break;
            case "wins":
                FootballLeagueService.sortByWins();
                break;
            case "goalDiff":
                FootballLeagueService.sortByGoalsDiff();
                break;
            case "receivedg":
                FootballLeagueService.sortByReceivedGoals();
                break;
            case "loses":
                FootballLeagueService.sortByLoses();
                break;
            case "scoredg":
                FootballLeagueService.sortByScoredGoals();
                break;
        }
        Object[][] footballTable = FootballLeagueService.displayLeagueTeable();
        System.out.println(footballTable[0][1]);
        LeagueTable.setModel(new DefaultTableModel(footballTable,columns));
        LeagueTable.setEnabled(false);
    }

    private void createPage3() {
        jPanel3 = new JPanel();
        jPanel3.setLayout(null);

        playerList = new JList();
        playerList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        playerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playerList.setToolTipText("Choose a Player");
        ScrollPlayers.setViewportView(playerList);
        ScrollPlayers.setBounds(20,150,200,250);
        ScrollPlayers.createVerticalScrollBar();

        deletePlayer.setForeground(new java.awt.Color(255, 51, 51));
        deletePlayer.setText("Delete Player");
        deletePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name[] = playerList.getSelectedValue().toString().split(" ");
                PlayerDatabase.deletePlayer(name[0]);
                updateData();
            }
        });
        deletePlayer.setBounds(35,420,150,30);

        managersList = new JList();
        managersList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        managersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        managersList.setToolTipText("Choose a Manager");
        ScrollManagers.setViewportView(managersList);
        ScrollManagers.setBounds(300,150,200,250);
        ScrollManagers.createVerticalScrollBar();

        deleteManager.setForeground(new java.awt.Color(255, 51, 51));
        deleteManager.setText("Delete Manager");
        deleteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name[] = managersList.getSelectedValue().toString().split(" ");
                ManagerDatabase.delete(name[0]);
                updateData();
            }
        });
        deleteManager.setBounds(315,420,150,30);

        insertPerson.setForeground(new java.awt.Color(0, 153, 0));
        insertPerson.setText("Add Person");
        insertPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonMenu(evt);
            }
        });
        insertPerson.setBounds(330,50,150,45);

        refereeList = new JList();
        ScrollReferees = new JScrollPane();
        refereeList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        refereeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        refereeList.setToolTipText("Choose a Referee");
        ScrollReferees.setViewportView(refereeList);
        ScrollReferees.setBounds(570,150,200,250);
        ScrollReferees.createVerticalScrollBar();


        deleteReferee.setForeground(new java.awt.Color(255, 51, 51));
        deleteReferee.setText("Delete Referee");
        deleteReferee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name[] = refereeList.getSelectedValue().toString().split(" ");
                RefereeDatabase.deleteReferee(name[0]);
                updateData();
            }
        });
        deleteReferee.setBounds(585, 420, 150,30);

        updateData();
        jPanel3.add(ScrollPlayers);
        jPanel3.add(deletePlayer);
        jPanel3.add(deleteManager);
        jPanel3.add(ScrollManagers);
        jPanel3.add(ScrollReferees);
        jPanel3.add(deleteReferee);
        jPanel3.add(insertPerson);
    }

    private void updateData(){
        PersonsService.readPersonsDataFromDatabase();

        DefaultListModel players = new DefaultListModel();
        for (Player player: PersonsService.getListOfPlayers())
            players.addElement(player.getLastName() + " " + player.getFirstName());
        playerList.setModel(players);

        DefaultListModel managers = new DefaultListModel();
        for (Manager manager: PersonsService.getListOfManagers())
            managers.addElement(manager.getLastName() + " " + manager.getFirstName());
        managersList.setModel(managers);

        DefaultListModel referees = new DefaultListModel();
        for (Referee refere: PersonsService.getListOfReferees())
            referees.addElement(refere.getLastName() + " " + refere.getFirstName());
        refereeList.setModel(referees);

    }

    private void addPersonMenu(ActionEvent evt){
        JFrame frameInsert = new JFrame("Insert Person");
        frameInsert.setLayout(null);

        JLabel nume = new JLabel();
        nume.setText("First Name");
        nume.setBounds(20,75,100,30);

        JLabel prenume = new JLabel();
        prenume.setText("Second Name");
        prenume.setBounds(20,100,100,30);

        JTextField numetxt = new JTextField();
        numetxt.setBounds(110,75,150,25);

        JTextField prenumetxt = new JTextField();
        prenumetxt.setBounds(110,100,150,25);

        JLabel datelabel = new JLabel();
        datelabel.setText("Birth Date");
        datelabel.setBounds(20,125,100,30);

        JXDatePicker date = new JXDatePicker();
        date.setBounds(110,125,150,25);

        JLabel weight = new JLabel();
        weight.setText("Weight");
        weight.setBounds(20,150,100,30);

        JLabel height = new JLabel();
        height.setText("Height");
        height.setBounds(20,175,100,30);

        JTextField weighttxt = new JTextField();
        weighttxt.setBounds(110,150,150,25);

        JTextField heighttext = new JTextField();
        heighttext.setBounds(110,175, 150,25);


        JLabel typetxt = new JLabel();
        typetxt.setText("Type of Person");
        typetxt.setBounds(20,200,100,30);

        DefaultComboBoxModel type = new DefaultComboBoxModel();
        type.addElement("Player");
        type.addElement("Manager");
        type.addElement("Referee");
        JComboBox personType = new JComboBox(type);
        personType.setSelectedIndex(0);

        personType.setBounds(110,200,150,25);

        JButton create = new JButton();
        create.setText("Add Person");
        create.setBounds(110,250,100,30);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numetxt.getText();
                String prenume = prenumetxt.getText();
                LocalDate birthdate = LocalDate.of(date.getDate().getYear(), date.getDate().getMonth(), date.getDate().getDay());
                double weight = Double.parseDouble(weighttxt.getText());
                double height = Double.parseDouble(heighttext.getText());
                if(personType.getSelectedIndex() == 0){
                    frameInsert.setVisible(false);
                    JFrame playerFrame = new JFrame();
                    playerFrame.setLayout(null);

                    JLabel position = new JLabel();
                    position.setText("Position");
                    position.setBounds(20,25,100,30);

                    JLabel number = new JLabel();
                    number.setText("Number");
                    number.setBounds(20,50,100,30);

                    JTextField positiontxt = new JTextField();
                    positiontxt.setBounds(110,25,150,25);

                    JTextField numbertxt = new JTextField();
                    numbertxt.setBounds(110,50,150,25);

                    JLabel club = new JLabel();
                    club.setText("Football Club");
                    club.setBounds(20,75,100,30);

                    JLabel foot = new JLabel();
                    foot.setText("Foot");
                    foot.setBounds(20,100,100,30);

                    JTextField clubtxt = new JTextField();
                    clubtxt.setBounds(110,75,150,25);

                    JTextField foottxt = new JTextField();
                    foottxt.setBounds(110,100, 150,25);

                    playerFrame.add(positiontxt);
                    playerFrame.add(position);
                    playerFrame.add(number);
                    playerFrame.add(club);
                    playerFrame.add(foot);
                    playerFrame.add(numbertxt);
                    playerFrame.add(clubtxt);
                    playerFrame.add(foottxt);

                    JButton create2 = new JButton();
                    create2.setText("Create Player");
                    create2.setBounds(110,150,150,30);
                    create2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String position = positiontxt.getText();
                            int number = Integer.parseInt(numbertxt.getText());
                            String club = clubtxt.getText();
                            String foot = foottxt.getText();
                            Player player = new Player(nume, prenume, birthdate, weight, height, position,number,club,foot);
                            PlayerDatabase.insertPlayer(player);
                            playerFrame.setVisible(false);
                            updateData();
                        }
                    });
                    playerFrame.add(create2);
                    playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    playerFrame.setPreferredSize(new Dimension(300,300));
                    playerFrame.setVisible(true);
                    playerFrame.pack();
                }
                else if (personType.getSelectedIndex() == 1){
                    String club = JOptionPane.showInputDialog("What club is he coaching ?");
                    Manager manager = new Manager(nume, prenume, LocalDate.of(date.getDate().getYear(), date.getDate().getMonth(), date.getDate().getDay()), weight, height, club);
                    ManagerDatabase.insertManager(manager);
                    frameInsert.setVisible(false);

                }
                else if (personType.getSelectedIndex() == 2){
                    String category = JOptionPane.showInputDialog("Referee's category ?");
                    Referee referee =  new Referee(nume, prenume, LocalDate.of(date.getDate().getYear(), date.getDate().getMonth(), date.getDate().getDay()), weight, height, category);
                    RefereeDatabase.insertReferee(referee);
                    frameInsert.setVisible(false);
                }
                updateData();
            }
        });


        frameInsert.add(create);
        frameInsert.add(nume);
        frameInsert.add(numetxt);
        frameInsert.add(prenume);
        frameInsert.add(prenumetxt);
        frameInsert.add(datelabel);
        frameInsert.add(date);
        frameInsert.add(weight);
        frameInsert.add(weighttxt);
        frameInsert.add(height);
        frameInsert.add(heighttext);
        frameInsert.add(personType);
        frameInsert.add(typetxt);
        frameInsert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInsert.setPreferredSize(new Dimension(500,500));
        frameInsert.setVisible(true);
        frameInsert.pack();


    }


    private javax.swing.JList TeamList;
    private JTable LeagueTable;
    private JList playerList;
    private JList refereeList;
    private JList managersList;
    private JScrollPane ScrollReferees;

    private javax.swing.JTable TeamMembersTable;
    private javax.swing.JLabel TeamScorL;
    private javax.swing.JLabel VicePresidentName;
    private javax.swing.JButton insertPerson;
    private javax.swing.JButton addWeek;
    private javax.swing.JTextField insertScorBox;
    private javax.swing.JButton deleteManager;
    private javax.swing.JTextField insertTeamBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane ScrollPlayers;
    private javax.swing.JScrollPane ScrollTable;
    private javax.swing.JScrollPane ScrollTeams;
    private javax.swing.JScrollPane ScrollManagers;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel loading;
    private javax.swing.JButton modifyLeague;
    private javax.swing.JButton deleteReferee;
    private javax.swing.JButton showTeam;
    private javax.swing.JButton deletePlayer;
    private JButton b;

    class DigitalWatch implements Runnable{
        Thread t=null;
        int hours=0, minutes=0, seconds=0;
        String timeString = "";

        DigitalWatch(){

            t = new Thread(this);
            t.start();

            b=new JButton();
            b.setBounds(100,700,100,50);
        }

        public void run() {
            try {
                while (true) {

                    Calendar cal = Calendar.getInstance();
                    hours = cal.get( Calendar.HOUR_OF_DAY );
                    if ( hours > 12 ) hours -= 12;
                    minutes = cal.get( Calendar.MINUTE );
                    seconds = cal.get( Calendar.SECOND );

                    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                    Date date = cal.getTime();
                    timeString = formatter.format( date );

                    printTime();

                    t.sleep( 1000 );  // interval given in milliseconds
                }
            }
            catch (Exception e) { }
        }

        public void printTime(){
            b.setText(timeString);
        }
    }

}
