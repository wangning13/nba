package ui.team;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import businesslogic.playerbl.PlayerRank;
import businesslogic.teambl.TeamRank;
import businesslogicservice.playerblservice.PlayerRankService;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.player.MyButtonUI;
import ui.player.MyComboBoxUI;
import ui.tools.MyTable;
import ui.tools.MyTable1;
import vo.PlayerVO;
import vo.TeamMonthMatchVO;
import vo.TeaminfoVO;

@SuppressWarnings("serial")
public class SingleTeam extends MyPanel implements ActionListener {
	boolean isRecent = true;
	String date;
	Object[][] data2;
	TeamRankService trs = new TeamRank();
	PlayerRankService prs = new PlayerRank();
	public boolean flag = false;
	String name;
	ArrayList<TeamMonthMatchVO> matches;
	Frame frame;
	Object[][] data;
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames1 = { "球员", "出场", "首发", "时间", "篮板", "助攻","抢断", "盖帽", "失误","犯规", "得分" };
	String[] columnNames2 = { "日期", "主队", "比分", "客队", "第一节", "第二节", "第三节",
			"第四节", "查看" };
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JLabel jl = new JLabel(Img.BOARD);
	JLabel jl1 = new JLabel("队名");
	JLabel jl2 = new JLabel("缩写");
	JLabel jl3 = new JLabel("城市");
	JLabel jl4 = new JLabel("联盟");
	JLabel jl5 = new JLabel("分区");
	JLabel jl6 = new JLabel("主场");
	JLabel jl7 = new JLabel("进入NBA");

	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();

	JLabel teamName = new JLabel("队名");
	JLabel abbreviation = new JLabel("缩写");
	JLabel city = new JLabel("城市");
	JLabel leagle = new JLabel("联盟");
	JLabel area = new JLabel("分区");
	JLabel home = new JLabel("主场");
	JLabel year = new JLabel("进入NBA");
	JLabel jl8 = new JLabel("比赛查询");
	JButton search = new JButton("查询");
	JButton recent = new JButton("最近五场");
	JButton analyze = new JButton("分析");
	JButton compare = new JButton("预测");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	JLabel teamIcon = new JLabel(Img.GSW);

	public SingleTeam(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		season.addItem("2015");
		season.addItem("2014");
		season.addItem("2013");
		season.addItem("2012");
		season.addItem("2011");
		season.addItem("2010");
		season.addItem("2009");
		season.addItem("2008");

		month.addItem("01月");
		month.addItem("02月");
		month.addItem("03月");
		month.addItem("04月");
		month.addItem("05月");
		month.addItem("06月");
		month.addItem("07月");
		month.addItem("08月");
		month.addItem("09月");
		month.addItem("10月");
		month.addItem("11月");
		month.addItem("12月");

		this.add(jl8);
		jl8.setBounds(630, 175, 70, 20);
		jl8.setFont(font1);

		this.add(season);
		season.setBounds(715, 175, 70, 20);
		season.setFont(font1);
		season.setUI(new MyComboBoxUI());
		
		this.add(month);
		month.setBounds(800, 175, 60, 20);
		month.setFont(font1);
		month.setUI(new MyComboBoxUI());

		this.add(search);
		search.setBounds(880, 172, 60, 25);
		search.addActionListener(this);
		search.setActionCommand("search");
		search.setUI(new MyButtonUI());
		
		this.add(recent);
		recent.setBounds(950, 172, 90, 25);
		recent.addActionListener(this);
		recent.setActionCommand("recent");
		recent.setUI(new MyButtonUI());
		
		this.add(analyze);
		analyze.setBounds(330, 172, 60, 25);
		analyze.addActionListener(this);
		analyze.setActionCommand("analyze");
		analyze.setUI(new MyButtonUI());
		
		this.add(compare);
		compare.setBounds(400, 172, 60, 25);
		compare.addActionListener(this);
		compare.setActionCommand("compare");
		compare.setUI(new MyButtonUI());


		this.add(rankingBand);
		rankingBand.setBounds(300, 150, 752, 70);

		this.add(teamIcon);
		teamIcon.setBounds(50, 155, 220, 220);

		this.add(jl1);
		jl1.setBounds(10, 370, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(10, 410, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(10, 450, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(10, 490, 100, 30);
		jl4.setFont(font1);
		this.add(jl5);
		jl5.setBounds(10, 530, 100, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(10, 570, 100, 30);
		jl6.setFont(font1);
		this.add(jl7);
		jl7.setBounds(10, 610, 100, 30);
		jl7.setFont(font1);

		this.add(teamName);
		teamName.setBounds(80, 370, 200, 30);
		teamName.setFont(font1);
		this.add(abbreviation);
		abbreviation.setBounds(80, 410, 200, 30);
		abbreviation.setFont(font1);
		this.add(city);
		city.setBounds(80, 450, 200, 30);
		city.setFont(font1);
		this.add(leagle);
		leagle.setBounds(80, 490, 200, 30);
		leagle.setFont(font1);
		this.add(area);
		area.setBounds(80, 530, 200, 30);
		area.setFont(font1);
		this.add(home);
		home.setBounds(80, 570, 250, 30);
		home.setFont(font1);
		this.add(year);
		year.setBounds(80, 610, 200, 30);
		year.setFont(font1);

		this.add(jl);
		jl.setBounds(0, 150, 300, 500);

		Object[][] data1 = null;
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable1(model1);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(300, 435, 752, 215);

		table1.addMouseListener(new MouseAdapter() { // 这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table1.getSelectedRow();
				int column = table1.getSelectedColumn();
				if (column == 0)
					jump1(row);
			}
		});

		Object[][] data2 = null;
		model2 = new DefaultTableModel(new Object[][] {}, columnNames2);
		model2.setDataVector(data2, columnNames2);
		table2 = new MyTable(model2);

		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane2 = new JScrollPane(table2);
		this.add(pane2);
		pane2.setBounds(300, 220, 752, 215);
		table2.addMouseListener(new MouseAdapter() { // 这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table2.getSelectedRow();
				int column = table2.getSelectedColumn();
				if (column == 8)
					jump(row);
			}
		});

	}

	public void update(String team) {
		name = team;
		changePIC(team);
		TeaminfoVO teamInfo = trs.getTeamInfo(team);
		teamName.setText(teamInfo.getName());
		abbreviation.setText(teamInfo.getAbbr());
		city.setText(teamInfo.getCity());
		leagle.setText(teamInfo.getLeague());
		area.setText(teamInfo.getPartition());
		home.setText(teamInfo.getCourt());
		year.setText(String.valueOf(teamInfo.getYear()));

		ArrayList<String> players = prs.getAllPlayer("14-15", team);

		int num = players.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			// System.out.println(players.get(i));
			PlayerVO player = prs.getPlayerdata("14-15", players.get(i));
			Object[] temp = { player.getPlayerName(), player.getAppearance(),
					player.getFirstPlay(), player.getMinutes(),player.getBackboard(),
					player.getAssist(), player.getSteal(), player.getBlock(), player.getTurnOver(),
					player.getFoul(), player.getScoring(), };
			data[i] = temp;
		}
		;
		model1.setDataVector(data, columnNames1);
		table1.setWidth();
		table1.updateUI();

		matches = trs.getTeamRecentFiveMatch("14-15",team);
		Object[][] data2 = getData(matches);
		model2.setDataVector(data2, columnNames2);
		table2.setWidth();
		table2.updateUI();

	}

	public void jump(int row) {
		frame.change(this, Frame.singleMatchPanel);
		TeamMonthMatchVO temp = matches.get(matches.size() - row - 1);
		Frame.singleMatchPanel.update(temp);
		Frame.singleMatchPanel.flag = true;
		Frame.currentPanel = "singleMatch";
	}

	public void jump1(int row) {
		if (table1.getValueAt(row, 0) != null) {
			String name = table1.getValueAt(row, 0).toString();
			if (!name.equals("")) {
				frame.change(this, Frame.singlePlayerPanel);
				Frame.singlePlayerPanel.update(name);
				Frame.singlePlayerPanel.flag = true;
				Frame.currentPanel = "singlePlayer";
			}
		}

	}

	public Object[][] getData(ArrayList<TeamMonthMatchVO> matches) {
		int num = matches.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { matches.get(i).getDate(),
					matches.get(i).getHost(), matches.get(i).getScore(),
					matches.get(i).getGuest(), matches.get(i).getFirst(),
					matches.get(i).getSecond(), matches.get(i).getThird(),
					matches.get(i).getFourth(), "查看" };
			data[num - 1 - i] = temp;
		}
		return data;
	}

	public void changePIC(String team) {
		ImageIcon icon = Img.ATL;
		if (team.equals("ATL")) {
			icon = Img.ATL;
		} else if (team.equals("BKN")) {
			icon = Img.BKN;
		} else if (team.equals("BOS")) {
			icon = Img.BOS;
		} else if (team.equals("CHA")) {
			icon = Img.CHA;
		} else if (team.equals("CHI")) {
			icon = Img.CHI;
		} else if (team.equals("CLE")) {
			icon = Img.CLE;
		} else if (team.equals("DAL")) {
			icon = Img.DAL;
		} else if (team.equals("DEN")) {
			icon = Img.DEN;
		} else if (team.equals("DET")) {
			icon = Img.DET;
		} else if (team.equals("GSW")) {
			icon = Img.GSW;
		} else if (team.equals("HOU")) {
			icon = Img.HOU;
		} else if (team.equals("IND")) {
			icon = Img.IND;
		} else if (team.equals("LAC")) {
			icon = Img.LAC;
		} else if (team.equals("LAL")) {
			icon = Img.LAL;
		} else if (team.equals("MEM")) {
			icon = Img.MEM;
		} else if (team.equals("MIA")) {
			icon = Img.MIA;
		} else if (team.equals("MIL")) {
			icon = Img.MIL;
		} else if (team.equals("MIN")) {
			icon = Img.MIN;
		} else if (team.equals("NOP")) {
			icon = Img.NOP;
		} else if (team.equals("NYK")) {
			icon = Img.NYK;
		} else if (team.equals("OKC")) {
			icon = Img.OKC;
		} else if (team.equals("ORL")) {
			icon = Img.ORL;
		} else if (team.equals("PHI")) {
			icon = Img.PHI;
			teamIcon.setIcon(Img.PHI);
		} else if (team.equals("PHX")) {
			icon = Img.PHX;
		} else if (team.equals("POR")) {
			icon = Img.POR;
		} else if (team.equals("SAC")) {
			icon = Img.SAC;
		} else if (team.equals("SAS")) {
			icon = Img.SAS;
		} else if (team.equals("TOR")) {
			icon = Img.TOR;
		} else if (team.equals("UTA")) {
			icon = Img.UTA;
		} else if (team.equals("WAS")) {
			icon = Img.WAS;
		}
		// icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
		teamIcon.setIcon(icon);
	}

	public void update() {
		if (isRecent) {
			matches = trs.getTeamRecentFiveMatch("14-15",name);
			data2 = getData(matches);
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {

					model2.setDataVector(data2, columnNames2);

		                 }
			 });
			
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {

					table2.setWidth();
		        	
		                 }
			 });
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {

					
		        	table2.updateUI();
		                 }
			 });
		} else {
			String temp = name;
			if(date.compareTo("13-10")<0&&temp.equals("NOP")){
				temp = "NOH";
			}
			matches = trs.getTeamMonthMatch(date, temp);
			data2 = getData(matches);

			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
					model2.setDataVector(data2, columnNames2);

		                 }
			 });
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
					table2.setWidth();
		        	
		                 }
			 });
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
					
		        	table2.updateUI();
		                 }
			 });
		}
		
		ArrayList<String> players = prs.getAllPlayer("14-15", name);

		int num = players.size();
		data = new Object[num][];
		for (int i = 0; i < num; i++) {
			// System.out.println(players.get(i));
			PlayerVO player = prs.getPlayerdata("14-15", players.get(i));
			Object[] temp = { player.getPlayerName(), player.getAppearance(),
					player.getFirstPlay(), player.getMinutes(),player.getBackboard(),
					player.getAssist(), player.getSteal(), player.getBlock(), player.getTurnOver(),
					player.getFoul(), player.getScoring(), };
			data[i] = temp;
		}
		
		
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	model1.setDataVector(data, columnNames1);
	                 }
		 });
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	table1.setWidth();
	                 }
		 });
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	table1.updateUI();
	                 }
		 });
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			if (flag) {
				frame.change(this, Frame.singlePlayerPanel);
				Frame.singlePlayerPanel.flag = false;
				Frame.currentPanel = "singlePlayer";
			} else {
				frame.change(this, Frame.teamsSelectPanel);
				Frame.currentPanel = "teamSelect";
			}
		} else if (e.getActionCommand().equals("search")) {
			date = season.getSelectedItem().toString().substring(2) + "-"
					+ month.getSelectedItem().toString().substring(0, 2);
			String temp = name;
			if(date.compareTo("13-10")<0&&temp.equals("NOP")){
				temp = "NOH";
			}
			matches = trs.getTeamMonthMatch(season.getSelectedItem().toString()
					.substring(2)
					+ "-" + month.getSelectedItem().toString().substring(0, 2),
					temp);
			Object[][] data2 = getData(matches);
			model2.setDataVector(data2, columnNames2);
			table2.setWidth();
			table2.updateUI();
			isRecent = false;
		} 
		else if (e.getActionCommand().equals("recent")) {
			matches = trs.getTeamRecentFiveMatch("14-15",name);
			Object[][] data2 = getData(matches);
			model2.setDataVector(data2, columnNames2);
			table2.setWidth();
			table2.updateUI();
			isRecent = true;
		}
		else if (e.getActionCommand().equals("analyze")) {
			frame.change(this, Frame.teamAnalyzePanel);
			Frame.teamAnalyzePanel.update(name);
			Frame.currentPanel = "teamAnalyze";
		}
		else if (e.getActionCommand().equals("compare")) {
			frame.change(this, Frame.teamsComparePanel);
			Frame.teamsComparePanel.update(name);
			Frame.teamsComparePanel.update(name);
			Frame.currentPanel = "teamsCompare";
		}
		
		

	}

}
