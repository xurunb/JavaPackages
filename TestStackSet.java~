public class TestStackSet {
  StackSet<String> set1,set2,set3;
  public TestStackSet() {
    //implement add before you do this.
    set1=new StackSet<String>();
    for(int i=1;i<=10;i++) {
      set1.add(""+i);
    }
    set1.add(""+7); //this is to make sure you don't add things twice.
    System.out.print("Set1=");
    set1.dumpIt();
    set2=new StackSet<String>();
    for(int i=5;i<=15;i++) {
      set2.add(""+i);
    }
    System.out.print("Set2=");
    set2.dumpIt();
    set3=new StackSet<String>();
    for(int i=1;i<11;i+=2) {
      set3.add(""+i);
    }
    System.out.print("Set3=");
    set3.dumpIt();
  }
  public void run() {
   /* System.out.print("Set1 union Set2=");
    set1.union(set2).dumpIt();
    System.out.println("Set1.contains(9)="+set1.contains(""+9));
    System.out.println("Set2.contains(4)="+set2.contains(""+4));
    System.out.print("Set1 intersect Set2=");
    set1.intersection(set2).dumpIt();
    System.out.print("Set1 - Set2=");
    set1.difference(set2).dumpIt();
    System.out.print("Set1 symmetricDifference Set2=");
    set1.symmetricDifference(set2).dumpIt();
    System.out.println("True or false: Set3 is a subset of Set1? "+
                     set1.subset(set3));
    System.out.println("True or false: Set3 is a subset of Set2? "+
                     set2.subset(set3));*/
  }
  public static void main(String [] args) {
    new TestStackSet().run();
  }
}