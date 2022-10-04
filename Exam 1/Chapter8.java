
public class Chapter8 {
 
  public static int min;
  public static int mid;
  public static int max;
  public static int num;
  public static int first;
  public static int second;
  public static int third;

  public static void getMin(){
    if(num < second && num < third){
        num=min;
    }
  }
  public static void getMid(){
    if(num > first && num < third){
        num=mid;
    }
  }
  public static void getMax(){
    if(num > first && num > third){
        num =max;
    }
  }
  
  public static void nested_selection(int first, int second, int third){
    
  }
  
public static void not_nested_selection(int first, int second, int third){
  
  
}
  public static void main(String[] args) {
  }
}