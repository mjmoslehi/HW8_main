package base.service;

import base.model.BaseEntity;
import base.repository.BaseRepository;

import java.io.Serializable;

public class BaseServiceImpel <ID extends Serializable, TYPE extends BaseEntity<ID>, R extends BaseRepository<ID, TYPE>>
        implements BaseService<ID, TYPE>{
}
