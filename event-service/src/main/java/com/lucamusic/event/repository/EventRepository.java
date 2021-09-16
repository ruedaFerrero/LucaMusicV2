package com.lucamusic.event.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.event.entity.Event;
/**
 * EventRepository
 * Repositorio de eventos conectado a una base de datos de Mongo
 * @author Jose Antonio
 * @version 1.0 Septiembre 2021
 *
 */
@Repository
public interface EventRepository extends MongoRepository<Event, String>{
	public List<Event> findAll();
	public Event findByName(String name);
    public List<Event> findAllByStatus(String status);
    public List<Event> findByMusicStyle(String musicStyle);
    //public List<Event> findByNameList(String name);
}
