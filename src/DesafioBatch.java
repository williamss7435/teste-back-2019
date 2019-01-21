public class DesafioBatch {
    
    public static void main(String[] args) {
        //Array de Clientes que serão inseridos no banco de dados
        Customer [] customers = {
            new Customer(1500, "450635334", "William", true, 1500f),
            new Customer(2700, "758654834", "Jose", true, 700.40f),
            new Customer(1144, "553654434", "Ana", true, 650.25f),
            new Customer(1000, "850614348", "Rogerio", true, 2500),
            new Customer(1233, "256653637", "Marcos", true, 5000),
            new Customer(1655, "356644530", "Mayara", true, 400),
            new Customer(1450, "620253334", "Raizza", true, 350.33f),
            new Customer(3000, "550555334", "Carlos", true, 324.21f),
            new Customer(3023, "302534335", "Vinicus", true, 600.32f),
            new Customer(1234, "150654334", "Tania", true, 400.10f),
            new Customer(1234, "250654334", "Higor", true, 100.2f),
            new Customer(6942, "350654334", "Carla", true, 380.23f),
            new Customer(1611, "350654334", "Suzana", true, 1500),
            new Customer(1511, "450654334", "Lorena", true, 3235.22f),
            new Customer(1687, "550654334", "Alexandre", true, 150),
            new Customer(2324, "650654334", "Rafael", true, 100),
            new Customer(1640, "750654334", "Vanessa", true, 470),
            new Customer(1503, "650654334", "Antonio", true, 8000),
            new Customer(1502, "650654334", "Lucas", true, 350),
            new Customer(4000, "450654334", "Thalita", true, 323),
            new Customer(1806, "650654334", "Juliana", true, 2345),
            new Customer(1666, "550654334", "Mirian", true, 234),
            new Customer(6542, "450655934", "Thiago", true, 236.7f),
            new Customer(5000, "352624334", "Lola", true, 50),
            new Customer(1503, "254655358", "Fabricio", true, 150),
            new Customer(1677, "252653334", "Paula", true, 400),
            new Customer(9000, "250658339", "Renan", true, 700),
            new Customer(1600, "352654364", "Felipe", true, 500),
            new Customer(1300, "450454631", "Maria", true, 232),
            new Customer(1661, "452454431", "Roberto", true, 1000),
            new Customer(1501, "153444531", "Beatriz", true, 1200),
            new Customer(1506, "556474141", "Soraya", true, 700),
        };
        
        //Nova Conexão Com o Banco (Host, Nome Do Banco, Usuario, Senha)
        DAOCustomer dbCustomers = new DAOCustomer("localhost", "db_desafio_back", "root", "");
        
        //Criação da Tabela tb_customer_account
        dbCustomers.createTableCustomer();
        
        //Metodo responsavel por salvar os dados no banco
        dbCustomers.saveCustomers(customers);
        
        //Metodo responsavel por Calcular a Média (Min valor do Id_customer, max valor do Id_customer, Vl_total Minimo) 
        System.out.println(dbCustomers.avereageSalary(1500, 2700, 560));
    }
    
}
