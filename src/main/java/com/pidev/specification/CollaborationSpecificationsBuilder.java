package com.pidev.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.pidev.models.Collaboration;
import com.pidev.models.CollaborationSpecification;
import com.pidev.models.SearchCriteria;

public class CollaborationSpecificationsBuilder {
    
    private final List<SearchCriteria> params;

    public CollaborationSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public CollaborationSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Collaboration> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
          .map(CollaborationSpecification::new)
          .collect(Collectors.toList());
        
        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
              .isOrPredicate()
                ? Specification.where(result)
                  .or(specs.get(i))
                : Specification.where(result)
                  .and(specs.get(i));
        }       
        return result;
    }
}