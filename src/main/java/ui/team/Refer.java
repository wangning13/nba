package ui.team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.JFreeUtils;
import ui.tools.MyTable1;


@SuppressWarnings("serial")
public class Refer extends MyPanel implements ActionListener {
	Frame frame;
	TeamRankService trs = new TeamRank();
	DecimalFormat df1=new DecimalFormat("#.00");
    JLabel jl = new JLabel("胜负影响因素");
    JLabel jl1 = new JLabel("主客场方差分析");
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 14);
	Font font2 = new Font("黑体", Font.BOLD, 40);
	JLabel blank = new JLabel(Img.BLANK);
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	String[] columnNames1 = {" " ,"主客场", "篮板", "失误", "助攻", "抢断", "盖帽","投篮命中", "三分命中", "罚球命中","对手篮板","对手失误","对手罚球"};
	JScrollPane pane2;
	MyTable1 table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"方差来源" ,"偏差平方和", "自由度", "方差", "F值", "Fa", "显著性"};

	double[] result1 = trs.LinerRegression("14-15");
	double[] result2 = trs.RegressionCoefficient("14-15");
	JLabel chart1 = new JLabel();
	public Refer(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
        this.add(jl);
        jl.setBounds(480,150,150,50);
        jl.setFont(new Font("黑体", Font.BOLD, 20));
        
        this.add(jl1);
        jl1.setBounds(650,350,150,50);
        jl1.setFont(new Font("黑体", Font.BOLD, 20));

        this.add(chart1);
        chart1.setBounds(0,300,500,350);
        
        for(int i=0;i<result2.length;i++){
        	result2[i] = Double.parseDouble(df1.format(result2[i]));
        }
        
		Object[][] data1 = getData1();
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable1(model1);  
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(0, 190, 1052, 93);
		
		Object[][] data2 = getData2();
		model2 = new DefaultTableModel(new Object[][] {}, columnNames2);
		model2.setDataVector(data2, columnNames2);
		table2 = new MyTable1(model2);  
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane2 = new JScrollPane(table2);
		this.add(pane2);
		pane2.setBounds(500, 420, 552, 123);
		

		this.add(blank);
		blank.setBounds(0,150,1052,500);
		
        updateChart();
	}

	
	public Object[][] getData1() {	
		Object[][] data = new Object[2][];
				
		Object[] temp = {"正/负相关","+","+","-","+","+","+","+","+","+","-","+","+","-"};
		data[0] = temp;
		Object[] temp1 = {"偏回归系数",result2[0],result2[1],result2[2],result2[4],result2[5],result2[6],result2[7],result2[8],result2[9],result2[10],result2[13],result2[14]};
		data[1] = temp1;
		return data;
	}
	
	public Object[][] getData2() {	
		Object[][] data = new Object[3][];
	    double[] a = trs.HostOrGuest("14-15");
	    for(int i=0;i<a.length;i++){
	    	a[i] = Double.parseDouble(df1.format(a[i]));
	    }
		Object[] temp = {"因素",a[0],a[3],a[6],a[8],"F(0.05)"+a[9],""};
		data[0] = temp;
		Object[] temp1 = {"误差",a[1],a[4],a[7],"","F(0.01)="+a[10],"**"};
		data[1] = temp1;
		Object[] temp2 = {"总和",a[2],a[5],"","","",""};
		data[2] = temp2;
		return data;
	}
	
	public void updateChart(){
		
		//初始化数据
		DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("主客场",result2[0]);
        dataset1.setValue("篮板",result2[1]);
        dataset1.setValue("失误",result2[2]);
        dataset1.setValue("助攻",result2[4]);
        dataset1.setValue("抢断",result2[5]);
        dataset1.setValue("盖帽",result2[6]);
        dataset1.setValue("投篮命中",result2[7]);
        dataset1.setValue("三分命中",result2[8]);
        dataset1.setValue("罚球命中",result2[9]);
        dataset1.setValue("对手篮板",result2[10]);
        dataset1.setValue("对手失误",result2[13]);
        dataset1.setValue("对手罚球",result2[14]);
        
		
		//生成图表
		JFreeChart chart = JFreeUtils.createPieChart(dataset1,"因素影响图",true);
		//生成图片
		JFreeUtils.drawToOutputStream("graphics/chart/饼图1.JPG", chart, 500, 350);
		ImageIcon icon = new ImageIcon(
				"graphics/chart/饼图1.JPG");
		icon.setImage(icon.getImage().getScaledInstance(500, 350,
				Image.SCALE_DEFAULT));
		chart1.setIcon(icon);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			frame.change(this, Frame.teamsComparePanel);
			Frame.currentPanel = "teamsCompare";
		} 
	}
}
