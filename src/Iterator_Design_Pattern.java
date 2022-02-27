public class Iterator_Design_Pattern {
    public static void main(String[] args) {
        collections ob=new collections();
        iterator_package ob1=ob.get_iterator();
        while(ob1.hasnext()){
            Object obj=ob1.next();
            int emp_id=(int)obj;
            System.out.println("The Employee Database Id are : "+emp_id);
        }
    }
}

interface iterator_package{
    public abstract boolean hasnext();
    public abstract Object next();
}

interface collection{
    public abstract iterator_package get_iterator();
}

class collections implements collection{
    int id[]={1,2,3,4,5};
    @Override
    public iterator_package get_iterator() {
        return new itr();
    }

    private class itr implements iterator_package{
        int index;
        @Override
        public boolean hasnext() {
            if(index<id.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasnext()){
                return id[index++];
            }
            return null;
        }
    }
}