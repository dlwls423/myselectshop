package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByUser(User user, Pageable pagable);

    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pagable);
    // select *
    // from product p left join product_folder pf
    // on p.id = pf.product_id
    // where p.user_id = ? and pf.folder_id = ?
}
