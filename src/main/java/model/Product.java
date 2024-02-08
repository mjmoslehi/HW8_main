package model;

import base.model.BaseEntity;

public class Product extends BaseEntity<Integer> {

    String name;
    int cost;
    int number;
    int categoryId;
}
