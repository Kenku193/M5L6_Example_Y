package org.example.constants;

public class SqlQuery {
    public static final String insertCarQuery = "INSERT INTO cars(model, human_id, cost) VALUES (?,?,?);";

    public static final String countQuery = "SELECT count(*) FROM humans;";
    public static final String selectHumanByIdQuery = "SELECT h.id id, h.age, h.name, h.balance, c.id cars_id, c.cost cars_cost, c.model cars_model FROM humans h JOIN cars c on h.id = c.human_id WHERE h.id = ?;";
    public static final String selectAllHumansQuery = "SELECT h.id id, h.age, h.name, h.balance, c.id cars_id, c.cost cars_cost, c.model cars_model FROM humans h JOIN cars c on h.id = c.human_id;";

    public static final String selectHumanByNameQuery = "SELECT h.id id, h.age, h.name, h.balance, c.id cars_id, c.cost cars_cost, c.model cars_model FROM humans h JOIN cars c on h.id = c.human_id WHERE name = ?;";

    public static final String updateCarOwnerIdQuery = "UPDATE cars SET human_id = ? WHERE id = ?;";

    public static final String insertDealQuery = "INSERT INTO deal_history(date, status, buyer_id, seller_id, car_id) VALUES (?,?,?,?,?);";

    public static final String findMaxDealHistoryIdQuery = "SELECT max(id) FROM deal_history;";






}
