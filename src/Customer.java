public class Customer {
    private int id;
    private String cpf;
    private String name;
    private boolean IsActive;
    private float vlTotal;

    public Customer(int id, String cpf, String name, boolean IsActive, float vlTotal) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.IsActive = IsActive;
        this.vlTotal = vlTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean IsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public float getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(float vlTotal) {
        this.vlTotal = vlTotal;
    }
    
    
    
}
