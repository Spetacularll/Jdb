package com.example.jeweryapp.demos.web.Repository;

import com.example.jeweryapp.demos.web.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
