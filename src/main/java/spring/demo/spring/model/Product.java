package spring.demo.spring.model;


public class Product {

    private Long id;
    private String title;
    private Integer cost;
    private Integer rate;


    public Product(Long id, String title, Integer cost, Integer rate) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.rate = rate;
    }

    public Product(Integer rate) {
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
