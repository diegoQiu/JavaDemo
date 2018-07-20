public class TestCircleWithPrivateDataFields{
    public static void main(String[] args) {
        CircleWithPrivateDataFields myCircle=new CircleWithPrivateDataFields(5.0);
        System.out.println("the area of the circle of radius "
        +myCircle.getRadius()+" is "+myCircle.getArea());

        myCircle.setRadius(myCircle.getRadius()*1.1);
        System.out.println("the area of the circle of radius "
       + myCircle.getRadius()+" is "+myCircle.getArea() );
        System.out.println("the number of objects created is "
        +CircleWithPrivateDataFields.getNumberOfObjects());
    }
}

