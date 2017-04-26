package com.bfl.es.utils;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/26 上午10:10
 * <p>Version: 1.0
 */
public class FootTagRuleBundle implements TagRuleBundle {
	@Override
	public void install(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		state.addRule("foot", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("foot"), false));
	}

	@Override
	public void cleanUp(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {

	}
}
