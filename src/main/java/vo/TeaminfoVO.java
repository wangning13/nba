package vo;

public class TeaminfoVO {

	String name;// 球队名字
	String abbr;// 缩写
	String city;// 所在城市
	String league;// 所在联盟
	String partition;// 所在分区
	String court;// 球场
	int year;// 创建时间

	public TeaminfoVO(String name, String abbr, String city, String league,
			String partition, String court, int year) {
		super();
		this.name = name;
		this.abbr = abbr;
		this.city = city;
		this.league = league;
		this.partition = partition;
		this.court = court;
		this.year = year;
	}

	public TeaminfoVO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	public String getCity() {
		return city;
	}

	public String getLeague() {
		return league;
	}

	public String getPartition() {
		return partition;
	}

	public String getCourt() {
		return court;
	}

	public int getYear() {
		return year;
	}

}