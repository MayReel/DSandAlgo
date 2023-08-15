package Unit2;


class Binary {

    private long[] a;
    private int nElement;
    public Binary(int max)
    {
        a = new long[max];
        nElement = 0;
    }

    public int size()
    {
        return nElement;
    }
    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElement-1;
        int curIn;
    
        while(true)
        {
            curIn = lowerBound + (upperBound - lowerBound)/2;
            if(a[curIn] == searchKey)
            {
                 return curIn; // found it
            }
            else if(lowerBound > upperBound)
            {
                return nElement; // cant find
            }
            else
            {
                if(a[curIn] < searchKey)
                {
                    lowerBound = curIn + 1; //if it in upper half
                }
                else
                {
                    upperBound = curIn - 1; //if it in lower half
                }
            }
        
        }

    }
    public void insert(long value)
    {
        int j;
        for(j=0;j<nElement;j++)
        {
            if(a[j]>value) // find where it goes
            {
                break;
            }
        }
        for(int k = nElement; k > j ; k--) //move bigger one up
        {
            a[k] = a[k-1];
        }
        a[j] = value; // insert it
        nElement++; //increment size
    }
    public boolean delete(long value)
    {
        int j = find(value);
        if(j==nElement)
        {
            return false;
        }
        else
        {
            for(int k = j; k < nElement; k++)
            {
                a[k] = a[k+1];
            }
            nElement--;
            return true;
        }
    }
    public void display()
    {
        for(int j = 0; j<nElement; j++)
        {
            System.out.print(a[j] + " ");
        }
        System.out.println(" ");
    }
}


class BinarySeachandInserting
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        Binary arr;
        arr = new Binary(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 35;

        if(arr.find(searchKey) != arr.size())
        {
            System.out.println("Found " + searchKey);
        }
        else
        {
            System.out.println("Cant find " + searchKey);
        }

        arr.display();

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}