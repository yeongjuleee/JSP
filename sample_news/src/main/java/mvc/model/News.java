package mvc.model;

public class News {
   private int aid;			// ��� ���� ��ȣ
   private String title;	// ��� ����
   private String img;		// ��� �̹��� �ּ�
   private String date;		// ��� ��¥
   private String content;	// ��� ����
   private String name;		// ��� �۾���
   
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