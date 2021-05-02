package com.javalec.function;

import java.io.InputStream;

public class Bean {

	String userid;
	String User_userid;
	String	username;
	int tablePK;
	int clothid;
//	int documentid;
//	int queryid;
//	int answerid;
//	int commentid;
	
//	int tableFK;
//	int Query_queryid;
//	int Document_documentid;
//	int Cloth_clothid;
//--------------------------------------------------------------------
	String content;
//	String	documentcontent;
//	String	commentcontent;
//	String	querycontent;
//	String	clothname;
	String name;
	String title; //
	String	clothtype;
	String clothname;
//	String	answercontent;
//	String	documenttitle;
//	String	querytitle;
	String	addtime;
	String	blindtime;
	InputStream	clothimage;
	int	likecount;
	int	documenttype;
	String	liketime;
	String	userpw;
	String	useremail;
	String	useraddtime;
	String	userblindtime;
	int	admin;
	String	userimage;
	
	String clothtype2;
//----------------------------------------------------------------------------

	
	public Bean(int tablePK, String content) {
		super();
		this.tablePK = tablePK;
		this.content = content;
	}
	public Bean(int tablePK, String title, String content, String user_userid, String addtime, String blindtime,
			InputStream clothimage) {
		//Cloth DB 사진 불러오기
		//Document DB 사진 불러오기
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.User_userid = user_userid;
		this.addtime = addtime;
		this.blindtime = blindtime;
		this.clothimage = clothimage;
	}
	public Bean(int tablePK, String title, String content,String username, String user_userid, String addtime, int admin) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.username = username;
		this.User_userid = user_userid;
		this.addtime = addtime;
		this.admin = admin;
	}
	public Bean(int tablePK, String title, String content, String addtime,
			String blindtime, String userid) {
		//Document DB Table 클릭시 데이터 불러오는 용
		//ClothDB table 불러오기
		super();
		this.userid = userid;
		this.tablePK = tablePK;
		this.content = content;
		this.title = title;
		this.addtime = addtime;
		this.blindtime = blindtime;
	}
	public Bean(String userid, int tablePK, String content, String addtime, String blindtime) {
		//Document DB Table 클릭시 댓글 데이터 불러오기
		super();
		this.userid = userid;
		this.tablePK = tablePK;
		this.content = content;
		this.addtime = addtime;
		this.blindtime = blindtime;
	}
	public Bean(int tablePK, String title, String content, InputStream clothimage, String addtime, String blindtime,
			 String user_userid) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.clothimage = clothimage;
		this.addtime = addtime;
		this.blindtime = blindtime;
		this.User_userid = user_userid;
	}
	public Bean(int tablePK, String title, String addtime, String username) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.username = username;
		this.addtime = addtime;
	}
	public Bean(int tablePK, String title, String content, String addtime, String username) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.addtime = addtime;
		this.username = username;
	}
	public Bean(int tablePK, String title, String content, int admin, String userid, String addtime, String blindtime) {
		super();
		this.tablePK = tablePK;
		this.title = title;
		this.content = content;
		this.admin = admin;
		//UpdateDocumentDB 같이 사용
		this.userid = userid;
		this.addtime = addtime;
		this.blindtime = blindtime;
	}
	public Bean(String userid, String username, String useremail, String useraddtime, String userblindtime, int admin) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.useraddtime = useraddtime;
		this.userblindtime = userblindtime;
		this.admin = admin;
	}
	public Bean(String content, String User_userid) {
		//1:1 문의 본인 댓글 확인
		this.content = content;
		this.User_userid = User_userid;	
	}
	
	public Bean(String clothtype, String clothname, String addtime) {
		super();
		this.clothtype = clothtype;
		this.clothname = clothname;
		this.addtime = addtime;
	}
	
	
	public Bean(String clothtype, String clothname, String addtime, InputStream clothimage) {
		super();
		this.clothtype = clothtype;
		this.clothname = clothname;
		this.addtime = addtime;
		this.clothimage = clothimage;
	}
	
	// jy2 : 추가 start
		public Bean(int tablePK, String title, String content, int admin, String userid, String addtime) {
			super();
			this.tablePK = tablePK;
			this.title = title;
			this.content = content;
			this.admin = admin;
			this.userid = userid;
			this.addtime = addtime;
		}
		// jy2 : 추가 end
		
		// jy2 : 추가 start
		
		public Bean(int clothid, String clothtype2, String clothname) {
			super();
			this.clothid = clothid;
			this.clothtype2 = clothtype2;
			this.clothname = clothname;
		}
		// jy2 : 추가 end
	//----------------------------------------------------------------------------
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUser_userid() {
		return User_userid;
	}
	public void setUser_userid(String user_userid) {
		User_userid = user_userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTablePK() {
		return tablePK;
	}
	public void setTablePK(int tablePK) {
		this.tablePK = tablePK;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getBlindtime() {
		return blindtime;
	}
	public void setBlindtime(String blindtime) {
		this.blindtime = blindtime;
	}
	public String getClothtype() {
		return clothtype;
	}
	public void setClothtype(String clothtype) {
		this.clothtype = clothtype;
	}
	
	public InputStream getClothimage() {
		return clothimage;
	}
	public void setClothimage(InputStream clothimage) {
		this.clothimage = clothimage;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getDocumenttype() {
		return documenttype;
	}
	public void setDocumenttype(int documenttype) {
		this.documenttype = documenttype;
	}
	public String getLiketime() {
		return liketime;
	}
	public void setLiketime(String liketime) {
		this.liketime = liketime;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseraddtime() {
		return useraddtime;
	}
	public void setUseraddtime(String useraddtime) {
		this.useraddtime = useraddtime;
	}
	public String getUserblindtime() {
		return userblindtime;
	}
	public void setUserblindtime(String userblindtime) {
		this.userblindtime = userblindtime;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}
	public String getClothname() {
		return clothname;
	}
	public void setClothname(String clothname) {
		this.clothname = clothname;
	}
	public int getClothid() {
		return clothid;
	}
	public void setClothid(int clothid) {
		this.clothid = clothid;
	}
	public String getClothtype2() {
		return clothtype2;
	}
	public void setClothtype2(String clothtype2) {
		this.clothtype2 = clothtype2;
	}
	
}