package miu.edu.EA_Lab3_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
//        jdbcTemplate.update("DELETE from customer",namedParameters);
//        jdbcTemplate.update("DELETE from creditcard",namedParameters);
        jdbcTemplate.update("DELETE from product",namedParameters);
    }

    public void save(Product product) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productnumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());

        jdbcTemplate.update("INSERT INTO product VALUES ( :productnumber, :name, :price)",namedParameters);

        }



    public Product getProductByNumber(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                        ));


        return product;

    }

    public Product getProductByName(String name){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", name);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "name =:name ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));


        return product;

    }

    public List<Product> getAllProduct(){
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));


        return products;
    }

    public void removeProductByName(String name) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("name", name);
        int rowsAffected = jdbcTemplate.update("DELETE FROM product WHERE name = :name", namedParameters);
        if (rowsAffected == 0) {
            throw new RuntimeException("No product with name " + name + " found.");
        }
    }


}
