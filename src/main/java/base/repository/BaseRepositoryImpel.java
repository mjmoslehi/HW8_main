package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;

public abstract class  BaseRepositoryImpel <ID extends Serializable , TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID , TYPE>{

}
