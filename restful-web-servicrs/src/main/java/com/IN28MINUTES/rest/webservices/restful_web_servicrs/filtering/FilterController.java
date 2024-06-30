package com.IN28MINUTES.rest.webservices.restful_web_servicrs.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/filtering")
public class FilterController {

    // Static Filtering
    @GetMapping("/someBean")
    public SomeBean someBean() {
        return new SomeBean("value1", "value2", "value3");
    }

    // Dynamic Filtering
    @GetMapping("/someBeanDynamic")
    public MappingJacksonValue someBeanDynamic() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
    //Static List Filtering
    @GetMapping("/someBeanList")
    public List<SomeBean> someBeanList() {
        return Arrays.asList(
            new SomeBean("value1", "value2", "value3"),
            new SomeBean("value4", "value5", "value6")
        );
    }
    //Dynamic Filtering
    @GetMapping("/someBeanListDynamic")
    public MappingJacksonValue someBeanListDynamic() {
        List<SomeBean> someBeanList = Arrays.asList(
            new SomeBean("value1", "value2", "value3"),
            new SomeBean("value4", "value5", "value6")
        );

        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3","field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}
