package ui.player;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import ui.tools.MyTable;
import ui.tools.MyTable1;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

@SuppressWarnings("serial")
public class SinglePlayer extends MyPanel implements ActionListener {
	boolean isRecent = true;
	String date = "";
	PlayerRankService prs = new PlayerRank();
	TeamRankService trs = new TeamRank();
	public boolean flag = false;
	ArrayList<PlayerMatchVO> matches;
	String playerName;
	String[] seasons={"14-15","13-14","12-13","11-12","10-11"};
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = { "赛季","所属球队", "参赛场数", "先发场数", "篮板数", "助攻数", "在场时间",
			"投篮命中率", "三分命中率", "罚球命中率", "进攻数", "防守数", "抢断数", "盖帽数", "失误数",
			"犯规数", "得分", "效率", "GmSc效率值", "真实命中率", "投篮效率", "篮板率", "进攻篮板率",
			"防守篮板率", "助攻率", "抢断率", "盖帽率", "失误率", "使用率", "场均得分", "场均时间", "场均篮板",
			"场均助攻", "场均投篮命中数", "场均投篮出手数", "场均三分命中数", "场均三分出手数", "场均罚球命中数",
			"场均罚球出手数", "场均进攻数", "场均防守数", "场均抢断数", "场均盖帽数", "场均失误数", "场均犯规数" };
	JScrollPane pane2;
	MyTable1 table2;
	DefaultTableModel model2;
	String[] columnNames2 = { "日期", "对手", "时间", "得分", "投篮", 
			"三分", "罚球", "前篮板", "后篮板", "篮板", "助攻",
			"盖帽", "犯规", "抢断", "失误" };
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();

	JLabel jl = new JLabel("比赛查询");
	JButton search = new JButton("查询");
	JButton recent = new JButton("最近五场");
	JButton compare = new JButton("比较");
	JButton analyze = new JButton("分析");
	JLabel jl1 = new JLabel("姓名");
	JLabel jl2 = new JLabel("号码");
	JLabel jl3 = new JLabel("位置");
	JLabel jl4 = new JLabel("身高");
	JLabel jl5 = new JLabel("体重");
	JLabel jl6 = new JLabel("生日");
	JLabel jl7 = new JLabel("年龄");
	JLabel jl8 = new JLabel("NBA球龄");
	JLabel jl9 = new JLabel("毕业学校");

	JLabel name = new JLabel("队名");
	JLabel number = new JLabel("缩写");
	JLabel position = new JLabel("城市");
	JLabel height = new JLabel("联盟");
	JLabel weight = new JLabel("分区");
	JLabel birth = new JLabel("主场");
	JLabel age = new JLabel("进入NBA");
	JLabel exp = new JLabel("进入NBA");
	JLabel school = new JLabel("进入NBA");

	JLabel playerIcon = new JLabel(Img.load("Jeremy Lin"));
	JLabel board = new JLabel(Img.BOARD1);
	// JButton enterTeam = new JButton("进入球队页面");

	Font font1 = new Font("黑体", Font.BOLD, 16);

	// Font font2 = new Font("黑体", Font.BOLD, 14);
	public SinglePlayer(Frame frame) {
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

		this.add(jl);
		jl.setBounds(630, 175, 70, 20);
		jl.setFont(font1);

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

		this.add(compare);
		compare.setBounds(270, 172, 60, 25);
		compare.addActionListener(this);
		compare.setActionCommand("compare");
		compare.setUI(new MyButtonUI());
		
		this.add(analyze);
		analyze.setBounds(350, 172, 60, 25);
		analyze.addActionListener(this);
		analyze.setActionCommand("analyze");
		analyze.setUI(new MyButtonUI());

		this.add(rankingBand);
		rankingBand.setBounds(250, 150, 802, 70);
		this.add(playerIcon);
		playerIcon.setBounds(10, 147, 230, 185);

		this.add(jl1);
		jl1.setBounds(10, 330, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(10, 365, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(10, 400, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(10, 435, 100, 30);
		jl4.setFont(font1);
		this.add(jl5);
		jl5.setBounds(10, 470, 100, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(10, 505, 100, 30);
		jl6.setFont(font1);
		this.add(jl7);
		jl7.setBounds(10, 540, 100, 30);
		jl7.setFont(font1);
		this.add(jl8);
		jl8.setBounds(10, 575, 100, 30);
		jl8.setFont(font1);
		this.add(jl9);
		jl9.setBounds(8, 610, 100, 30);
		jl9.setFont(font1);

		this.add(name);
		name.setBounds(80, 330, 200, 30);
		name.setFont(font1);
		this.add(number);
		number.setBounds(80, 365, 200, 30);
		number.setFont(font1);
		this.add(position);
		position.setBounds(80, 400, 200, 30);
		position.setFont(font1);
		this.add(height);
		height.setBounds(80, 435, 200, 30);
		height.setFont(font1);
		this.add(weight);
		weight.setBounds(80, 470, 200, 30);
		weight.setFont(font1);
		this.add(birth);
		birth.setBounds(80, 505, 200, 30);
		birth.setFont(font1);
		this.add(age);
		age.setBounds(80, 540, 200, 30);
		age.setFont(font1);
		this.add(exp);
		exp.setBounds(80, 575, 200, 30);
		exp.setFont(font1);
		this.add(school);
		school.setBounds(80, 610, 200, 30);
		school.setFont(font1);

		this.add(board);
		board.setBounds(0, 150, 250, 500);

		Object[][] data1 = null;
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable(model1);
		table1.addMouseListener(new MouseAdapter() { // 这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table1.getSelectedRow();
				int column = table1.getSelectedColumn();
				if (column == 1)
					jump(row);
			}
		});
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(250, 460, 802, 200);

		Object[][] data2 = null;
		model2 = new DefaultTableModel(new Object[][] {}, columnNames2);
		model2.setDataVector(data2, columnNames2);
		table2 = new MyTable1(model2);

	    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane2 = new JScrollPane(table2);
		this.add(pane2);
		pane2.setBounds(250, 220, 802, 240);

	}

	public void update(String name) {
		playerName = name;
		playerIcon.setIcon(Img.load(name));
		PlayerinfoVO playerInfo = prs.getPlayerinfo(name);
		this.name.setText(name);
		number.setText(playerInfo.getNumber());
		position.setText(playerInfo.getPosition());
		height.setText(playerInfo.getHeight());
		weight.setText(String.valueOf(playerInfo.getWeight()));
		birth.setText(playerInfo.getBirth());
		age.setText(String.valueOf(playerInfo.getAge()));
		exp.setText(playerInfo.getExp());
		school.setText(playerInfo.getSchool());

		ArrayList<PlayerVO> player = new ArrayList<PlayerVO>(0);
		for(int i=0;i<5;i++){
		    PlayerVO temp = prs.getPlayerdata(seasons[i], name);
		    if(!temp.getTeam().equals(""))
		    	player.add(temp);
		}
		
		int num = player.size();
		Object[][] data1 = new Object[num][];
        for(int i = 0 ;i<num;i++){
		Object[] temp1 = { 
				seasons[i],
				player.get(i).getTeam(), player.get(i).getAppearance(),
				player.get(i).getFirstPlay(), player.get(i).getBackboard(),
				player.get(i).getAssist(), player.get(i).getMinutes(),
				player.get(i).getFielfGoalShotPercentage(),
				player.get(i).getThreePointShotPercentage(),
				player.get(i).getFreeThrowPercentage(), player.get(i).getOffensiveRebound(),
				player.get(i).getDefensiveRebound(), player.get(i).getSteal(),
				player.get(i).getBlock(), player.get(i).getTurnOver(), player.get(i).getFoul(),
				player.get(i).getScoring(), player.get(i).getEfficiency(),
				player.get(i).getGmScEfficiency(), player.get(i).getTrueShootingPercentage(),
				player.get(i).getShootingEfficiency(),
				player.get(i).getBackboardPercentage(),
				player.get(i).getOffensiveReboundPercentage(),
				player.get(i).getDefensiveReboundPercentage(),
				player.get(i).getAssistPercentage(), player.get(i).getStealPercentage(),
				player.get(i).getBlockPercentage(), player.get(i).getTurnOverPercentage(),
				player.get(i).getUsage(), player.get(i).getAverageScoring(),
				player.get(i).getAverageMinute(), player.get(i).getAverageBackboard(),
				player.get(i).getAverageAssist(), player.get(i).getAverageFieldGoal(),
				player.get(i).getAverageFieldGoalAttempts(),
				player.get(i).getAverageThreePointFieldGoal(),
				player.get(i).getAverageThreePointFieldGoalAttempts(),
				player.get(i).getAverageFreeThrow(),
				player.get(i).getAverageFreeThrowAttempts(),
				player.get(i).getAverageOffensiveRebound(),
				player.get(i).getAverageDefensiveRebound(), player.get(i).getAverageSteal(),
				player.get(i).getAverageBlock(), player.get(i).getAverageTurn(),
				player.get(i).getAverageFoul() };
		        data1[i] = temp1;
        }

		model1.setDataVector(data1, columnNames1);
		table1.setWidth();
		table1.updateUI();

		/*
		 * Object[][] data2 = new Object[1][];
		 * 
		 * Object[] temp2 =
		 * {player.getAverageScoring(),player.getAverageMinute()
		 * ,player.getAverageBackboard
		 * (),player.getAverageAssist(),player.getAverageFieldGoal
		 * (),player.getAverageFieldGoalAttempts
		 * (),player.getAverageThreePointFieldGoal
		 * (),player.getAverageThreePointFieldGoalAttempts
		 * (),player.getAverageFreeThrow
		 * (),player.getAverageFreeThrowAttempts(),player
		 * .getAverageOffensiveRebound
		 * (),player.getAverageDefensiveRebound(),player
		 * .getAverageSteal(),player
		 * .getAverageBlock(),player.getAverageTurn(),player.getAverageFoul()};
		 * data2[0] = temp2;
		 * 
		 * model2.setDataVector(data2, columnNames2); table2.setWidth();
		 * table2.updateUI();
		 */
		matches = prs.getPlayerRecentFiveMatch("14-15",name);
		model2.setDataVector(getData2(matches), columnNames2);
		table2.setWidth();
		table2.updateUI();
	}

	public void jump(int row) {
		if (table1.getValueAt(row, 1) != null) {
			String team = table1.getValueAt(row, 1).toString();
			frame.change(this, Frame.singleTeamPanel);
			Frame.singleTeamPanel.update(team);
			Frame.singleTeamPanel.flag = true;
			Frame.currentPanel = "singleTeam";
		}
	}

	public Object[][] getData2(ArrayList<PlayerMatchVO> matches) {
		int num = matches.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = {
					matches.get(i).getDate(),
					trs.getTeamMatch(matches.get(i).getDate(),
							matches.get(i).getTeam()).getOpponent(),
					matches.get(i).getMinutes(), matches.get(i).getScoring(),
					matches.get(i).getFieldGoal()+"-"+matches.get(i).getFieldGoalAttempts(),
					
					matches.get(i).getThreepointFieldGoal()+"-"+matches.get(i).getThreepointFieldGoalAttempts(),
					
					matches.get(i).getFreeThrow()+"-"+matches.get(i).getFreeThrowAttempts(),
					
					matches.get(i).getOffensiveRebound(),
					matches.get(i).getDefensiveRebound(),
					matches.get(i).getBackboard(), matches.get(i).getAssist(),
					matches.get(i).getBlock(), matches.get(i).getFoul(),
					matches.get(i).getSteal(), matches.get(i).getTurnOver() };
			data[i] = temp;
		}
		return data;
	}
/*
	public void update() {
		
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	PlayerVO player = prs.getPlayerdata("14-15", playerName);
	    		Object[][] data1 = new Object[1][];
	    		Object[] temp1 = { player.getTeam(), player.getAppearance(),
	    				player.getFirstPlay(), player.getBackboard(),
	    				player.getAssist(), player.getMinutes(),
	    				player.getFielfGoalShotPercentage(),
	    				player.getThreePointShotPercentage(),
	    				player.getFreeThrowPercentage(), player.getOffensiveRebound(),
	    				player.getDefensiveRebound(), player.getSteal(),
	    				player.getBlock(), player.getTurnOver(), player.getFoul(),
	    				player.getScoring(), player.getEfficiency(),
	    				player.getGmScEfficiency(), player.getTrueShootingPercentage(),
	    				player.getShootingEfficiency(),
	    				player.getBackboardPercentage(),
	    				player.getOffensiveReboundPercentage(),
	    				player.getDefensiveReboundPercentage(),
	    				player.getAssistPercentage(), player.getStealPercentage(),
	    				player.getBlockPercentage(), player.getTurnOverPercentage(),
	    				player.getUsage(), player.getAverageScoring(),
	    				player.getAverageMinute(), player.getAverageBackboard(),
	    				player.getAverageAssist(), player.getAverageFieldGoal(),
	    				player.getAverageFieldGoalAttempts(),
	    				player.getAverageThreePointFieldGoal(),
	    				player.getAverageThreePointFieldGoalAttempts(),
	    				player.getAverageFreeThrow(),
	    				player.getAverageFreeThrowAttempts(),
	    				player.getAverageOffensiveRebound(),
	    				player.getAverageDefensiveRebound(), player.getAverageSteal(),
	    				player.getAverageBlock(), player.getAverageTurn(),
	    				player.getAverageFoul() };
	    		data1[0] = temp1;
	    		model1.setDataVector(data1, columnNames1);
	    		table1.setWidth();
	        	table1.updateUI();
	                 }
		 });
		if (isRecent) {

			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
					matches = prs.getPlayerRecentFiveMatch("14-15",playerName);
					model2.setDataVector(getData2(matches), columnNames2);
					table2.setWidth();
		        	table2.updateUI();
		                 }
			 });
		} else {
			matches = prs.getPlayerMonthMatch("14-15",date,
					playerName);
			model2.setDataVector(getData2(matches), columnNames2);
			table2.setWidth();
			SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		        	table2.updateUI();
		                 }
			 });
		}
	}*/


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			if (flag) {
				frame.change(this, Frame.singleTeamPanel);
				Frame.singleTeamPanel.flag = false;
				Frame.currentPanel = "singleTeam";
			} else {
				frame.change(this, Frame.playersSelectPanel);
				Frame.currentPanel = "playersSelect";
			}
		} else if (e.getActionCommand().equals("search")) {
			matches = prs.getPlayerMonthMatch(season.getSelectedItem()
					.toString().substring(2)
					+ "-" + month.getSelectedItem().toString().substring(0, 2),
					playerName);
			model2.setDataVector(getData2(matches), columnNames2);
			table2.setWidth();
			table2.updateUI();
			isRecent = false;
			date = season.getSelectedItem().toString().substring(2) + "-"
					+ month.getSelectedItem().toString().substring(0, 2);
		} else if (e.getActionCommand().equals("recent")) {
			matches = prs.getPlayerRecentFiveMatch("14-15",playerName);
			model2.setDataVector(getData2(matches), columnNames2);
			table2.setWidth();
			table2.updateUI();
			isRecent = true;
		}
		 else if (e.getActionCommand().equals("compare")) {
				frame.change(this, Frame.playersComparePanel);
				Frame.playersComparePanel.update(playerName);
				Frame.currentPanel = "playersCompare";
			}
		 else if (e.getActionCommand().equals("analyze")) {
				frame.change(this, Frame.playerAnalyzePanel);
				Frame.playerAnalyzePanel.update(playerName);
				Frame.currentPanel = "playerAnalyze";
			}
	}
}
