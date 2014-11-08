package com.virtual.queue.builder;

import java.util.ArrayList;
import java.util.List;

import com.virtual.queue.rule.DuplicateUserRule;
import com.virtual.queue.rule.Rule;

public class RuleBuilderImp implements RuleBuilder{

	@Override
	public List<Rule> buildRules() {
		
		List<Rule> list=new ArrayList<Rule>();
		
		list.add(new DuplicateUserRule());
		
		
		
		// TODO Auto-generated method stub
		return list;
	}

}
