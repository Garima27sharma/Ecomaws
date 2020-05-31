public class Productspecification {

     public String name;
     public Long price;
     public String colour;
     public String category;
     public Double discountPercentage;


    public String getName(){
         return name;
     }
     public void setName(String name)
     {
         this.name=name;
     }
     public Long getPrice()
     {
         return price;
     }
     public void setPrice(Long price)
     {
         this.price=price;
     }
     public String getColour()
     {
         return colour;
     }
     public void setColour(String colour)
     {
         this.colour=colour;
     }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category=category;
    }
    public Double getDiscountPercentage()
    {
        return discountPercentage;
    }
    public void setDiscountPercentage(Double discountPercentage)
    {
        this.discountPercentage=discountPercentage;
    }

}
