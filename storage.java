import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class storage {
    private SimpleStringProperty name;
    private SimpleIntegerProperty code;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty price;
    private SimpleDoubleProperty discount;

    public storage(String n, int a, int b, double x, double y)
    {
        name=new SimpleStringProperty(n);
        code=new SimpleIntegerProperty(a);
        quantity=new SimpleIntegerProperty(b);
        price=new SimpleDoubleProperty(x);
        discount=new SimpleDoubleProperty(y);

    }

    public String getName()
    {
        return name.get();
    }

    public int getCode()
    {
        return code.get();
    }

    public int getQuantity()
    {
        return quantity.get();
    }

    public double getPrice()
    {
        return price.get();
    }

    public double getDiscount()
    {
        return discount.get();
    }

    /////////////////////////////////////////////////////////

    public void setName(String n)
    {
        name.set(n);
    }

    public void setCode(int i)
    {
        code.set(i);
    }

    public void setQuantity(int j)
    {
        quantity.set(j);
    }

    public void setPrice(double m)
    {
        price.set(m);
    }

    public void setDiscount(double n)
    {
        discount.set(n);
    }




}
