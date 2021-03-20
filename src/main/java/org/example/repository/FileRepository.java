package org.example.repository;

/**
 * CRUD operations file ro.ubb.racheta.ro.ubb.org.example.repository interface
 * @param <ID> - type E must have an attribute of type ID
 * @param <E> - type of entities saved in ro.ubb.racheta.ro.ubb.org.example.repository
 */
public interface FileRepository<ID, E extends HasID<ID>> {

    /**
     * Incarca datele din fisier
     */
    void loadFromFile();

    /**
     * Scrie un obiect nou in fisier
     * @param entity - obiectul pe care il scrie
     */
    void saveToFile(E entity);

    /**
     * Rescrie fisierul
     */
    void writeToFile();
}