package fr.formation.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface QuestRepositoryBase<T> extends PanacheRepositoryBase<T, Integer> {
	public default boolean existsById(Integer id) {
		return this.find("id", id).firstResultOptional().isPresent();
	}
}
