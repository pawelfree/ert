package pl.pd.emir.admin;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import pl.pd.emir.commons.AbstractManagerTemplate;
import pl.pd.emir.entity.administration.Parameter;
import pl.pd.emir.enums.ParameterKey;

@Stateless
public class ParameterManager extends AbstractManagerTemplate<Parameter> {

    public ParameterManager() {
        super(Parameter.class);
    }

    public Parameter get(ParameterKey key) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Parameter> cq = cb.createQuery(Parameter.class);
        Root<Parameter> param = cq.from(Parameter.class);
        cq.select(param);
        Predicate p = cb.equal(param.get("key"), key);
        cq.where(p);
        TypedQuery<Parameter> q = entityManager.createQuery(cq);
        List<Parameter> resultList = q.setMaxResults(1).getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public String getValue(ParameterKey key) {
        return get(key) == null ? null : get(key).getValue();
    }

}
