package Unit2;
class Person
{
    private String lastName;
    private String firstName;
    private int age;
//----------------------------------------
    public Person(String last, String first, int a)
    {   //constructor
        lastName = last;
        firstName = first;
        age = a;
    }

    public void displayPerson()
    {
        System.out.print("    Last name: " + lastName);
        System.out.print(", First name: " );
        System.out.println(", Age: " + age);
    }

    public String getLast()
    {
        return lastName;
    }

}
////////////////////////////////////////////////////
class ClassDataArray 
{
    private Person[] a; 
    private int nElement;
    
    public ClassDataArray(int max)  // construct
    {
        a = new Person[max];
        nElement = 0;
    }

    public Person find(String searchName)
    {                               //find specified value
        int j;
        for(j=0;j<nElement;j++)
        {
            if(a[j].getLast().equals(searchName)) //searchName
            {
                break;                          //exit loop before end
            }
        }
        if(j == nElement)                       //gone to end
        {
            return null;                        //yes cant find it
        }
        else
        {
            return a[j];                        //no found it
        }
    }

    public void insert(String last, String first, int age)
    {
        a[nElement] = new Person(last, first, age);
        nElement++;
    }

    public boolean delete(String searchName)
    {   //delete person from array
        int j;
        for(j=0;j<nElement;j++) // look for it
        {
            if(a[j].getLast().equals(searchName))
            {
                break;
            }
        }
        if(j==nElement) //cant find it
        {
            return false;
        }
        else
        {
            for(int k = j ; k < nElement ; k++)
            {
                a[k] = a[k+1];
            }
            nElement--;
            return true;
        }
    }
    public void displayA()
    {
        for(int j = 0 ; j < nElement ; j++)
        {
            a[j].displayPerson();   
        }
    }
}

class ClassDataApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        ClassDataArray arr;
        arr = new ClassDataArray(maxSize);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.displayA();

        String searchKey = "Stimson";
        Person found;
        found = arr.find(searchKey);
        if(found != null)
        {
            System.out.print("Found ");
            found.displayPerson();
        }
        else
        {
            System.out.println("Cant find " + searchKey);
        }
        System.out.println("Eleting Smith ,Yee , and Creswell");
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");

        arr.displayA();
    }
}
