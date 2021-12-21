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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
