package mvc.model;

public class News {
   private int aid;			// 기사 고유 번호
   private String title;	// 기사 제목
   private String img;		// 기사 이미지 주소
   private String date;		// 기사 날짜
   private String content;	// 기사 내용
   private String name;		// 기사 글쓴이
   
   public int getAid() {
      return aid;
   }
   
   public void setAid(int aid) {
      this.aid = aid;
   }
   
   public String getTitle() {
      return title;
   }
   
   public void setTitle(String title) {
      this.title = title;
   }
   
   public String getImg() {
      return img;
   }
   
   public void setImg(String img) {
      this.img = img;
   }
   
   public String getDate() {
      return date;
   }
   
   public void setDate(String date) {
      this.date = date;
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

   
   
   
}