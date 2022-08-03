package com.example.CriteriaDemo.service;

import com.example.CriteriaDemo.model.ProductFilters;
import com.example.CriteriaDemo.model.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDAO {//data access object

    private final EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<Product> getAll(ProductFilters filters) {
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        List<Predicate> whereClauses = getClauses(filters, productRoot);

        CriteriaQuery<Product> query = criteriaQuery.select(productRoot).where(whereClauses.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> getClauses(ProductFilters filters, Root<Product> productRoot) {
        List<Predicate> clauses = new ArrayList<>();
        Optional.ofNullable(filters.getBrand())
                .ifPresent(brand -> clauses.add(criteriaBuilder.equal(productRoot.get("brand"), brand)));
        Optional.ofNullable(filters.getBrand())
                .ifPresent(category -> clauses.add(criteriaBuilder.equal(productRoot.get("category"), category)));
        Optional.ofNullable(filters.getBrand())
                .ifPresent(os -> clauses.add(criteriaBuilder.equal(productRoot.get("os"), os)));
        Optional.ofNullable(filters.getBrand())
                .ifPresent(price -> clauses.add(criteriaBuilder.lessThanOrEqualTo(productRoot.get("price"), price)));
        return clauses;
    }
}
