/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.journal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalFeed;
import com.liferay.portlet.journal.model.JournalFeedModel;
import com.liferay.portlet.journal.model.JournalFeedSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JournalFeed service. Represents a row in the &quot;JournalFeed&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.journal.model.JournalFeedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalFeedImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalFeedImpl
 * @see com.liferay.portlet.journal.model.JournalFeed
 * @see com.liferay.portlet.journal.model.JournalFeedModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class JournalFeedModelImpl extends BaseModelImpl<JournalFeed>
	implements JournalFeedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal feed model instance should use the {@link com.liferay.portlet.journal.model.JournalFeed} interface instead.
	 */
	public static final String TABLE_NAME = "JournalFeed";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "feedId", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "structureId", Types.VARCHAR },
			{ "templateId", Types.VARCHAR },
			{ "rendererTemplateId", Types.VARCHAR },
			{ "delta", Types.INTEGER },
			{ "orderByCol", Types.VARCHAR },
			{ "orderByType", Types.VARCHAR },
			{ "targetLayoutFriendlyUrl", Types.VARCHAR },
			{ "targetPortletId", Types.VARCHAR },
			{ "contentField", Types.VARCHAR },
			{ "feedFormat", Types.VARCHAR },
			{ "feedVersion", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table JournalFeed (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,feedId VARCHAR(75) null,name VARCHAR(75) null,description STRING null,structureId VARCHAR(75) null,templateId VARCHAR(75) null,rendererTemplateId VARCHAR(75) null,delta INTEGER,orderByCol VARCHAR(75) null,orderByType VARCHAR(75) null,targetLayoutFriendlyUrl VARCHAR(255) null,targetPortletId VARCHAR(75) null,contentField VARCHAR(75) null,feedFormat VARCHAR(75) null,feedVersion DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table JournalFeed";
	public static final String ORDER_BY_JPQL = " ORDER BY journalFeed.feedId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JournalFeed.feedId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.journal.model.JournalFeed"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.journal.model.JournalFeed"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.journal.model.JournalFeed"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long FEEDID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JournalFeed toModel(JournalFeedSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JournalFeed model = new JournalFeedImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFeedId(soapModel.getFeedId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setStructureId(soapModel.getStructureId());
		model.setTemplateId(soapModel.getTemplateId());
		model.setRendererTemplateId(soapModel.getRendererTemplateId());
		model.setDelta(soapModel.getDelta());
		model.setOrderByCol(soapModel.getOrderByCol());
		model.setOrderByType(soapModel.getOrderByType());
		model.setTargetLayoutFriendlyUrl(soapModel.getTargetLayoutFriendlyUrl());
		model.setTargetPortletId(soapModel.getTargetPortletId());
		model.setContentField(soapModel.getContentField());
		model.setFeedFormat(soapModel.getFeedFormat());
		model.setFeedVersion(soapModel.getFeedVersion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JournalFeed> toModels(JournalFeedSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JournalFeed> models = new ArrayList<JournalFeed>(soapModels.length);

		for (JournalFeedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.journal.model.JournalFeed"));

	public JournalFeedModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JournalFeed.class;
	}

	@Override
	public String getModelClassName() {
		return JournalFeed.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feedId", getFeedId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("structureId", getStructureId());
		attributes.put("templateId", getTemplateId());
		attributes.put("rendererTemplateId", getRendererTemplateId());
		attributes.put("delta", getDelta());
		attributes.put("orderByCol", getOrderByCol());
		attributes.put("orderByType", getOrderByType());
		attributes.put("targetLayoutFriendlyUrl", getTargetLayoutFriendlyUrl());
		attributes.put("targetPortletId", getTargetPortletId());
		attributes.put("contentField", getContentField());
		attributes.put("feedFormat", getFeedFormat());
		attributes.put("feedVersion", getFeedVersion());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String feedId = (String)attributes.get("feedId");

		if (feedId != null) {
			setFeedId(feedId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String structureId = (String)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}

		String templateId = (String)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String rendererTemplateId = (String)attributes.get("rendererTemplateId");

		if (rendererTemplateId != null) {
			setRendererTemplateId(rendererTemplateId);
		}

		Integer delta = (Integer)attributes.get("delta");

		if (delta != null) {
			setDelta(delta);
		}

		String orderByCol = (String)attributes.get("orderByCol");

		if (orderByCol != null) {
			setOrderByCol(orderByCol);
		}

		String orderByType = (String)attributes.get("orderByType");

		if (orderByType != null) {
			setOrderByType(orderByType);
		}

		String targetLayoutFriendlyUrl = (String)attributes.get(
				"targetLayoutFriendlyUrl");

		if (targetLayoutFriendlyUrl != null) {
			setTargetLayoutFriendlyUrl(targetLayoutFriendlyUrl);
		}

		String targetPortletId = (String)attributes.get("targetPortletId");

		if (targetPortletId != null) {
			setTargetPortletId(targetPortletId);
		}

		String contentField = (String)attributes.get("contentField");

		if (contentField != null) {
			setContentField(contentField);
		}

		String feedFormat = (String)attributes.get("feedFormat");

		if (feedFormat != null) {
			setFeedFormat(feedFormat);
		}

		Double feedVersion = (Double)attributes.get("feedVersion");

		if (feedVersion != null) {
			setFeedVersion(feedVersion);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFeedId() {
		if (_feedId == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedId;
		}
	}

	@Override
	public void setFeedId(String feedId) {
		_columnBitmask = -1L;

		if (_originalFeedId == null) {
			_originalFeedId = _feedId;
		}

		_feedId = feedId;
	}

	public String getOriginalFeedId() {
		return GetterUtil.getString(_originalFeedId);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getStructureId() {
		if (_structureId == null) {
			return StringPool.BLANK;
		}
		else {
			return _structureId;
		}
	}

	@Override
	public void setStructureId(String structureId) {
		_structureId = structureId;
	}

	@JSON
	@Override
	public String getTemplateId() {
		if (_templateId == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateId;
		}
	}

	@Override
	public void setTemplateId(String templateId) {
		_templateId = templateId;
	}

	@JSON
	@Override
	public String getRendererTemplateId() {
		if (_rendererTemplateId == null) {
			return StringPool.BLANK;
		}
		else {
			return _rendererTemplateId;
		}
	}

	@Override
	public void setRendererTemplateId(String rendererTemplateId) {
		_rendererTemplateId = rendererTemplateId;
	}

	@JSON
	@Override
	public int getDelta() {
		return _delta;
	}

	@Override
	public void setDelta(int delta) {
		_delta = delta;
	}

	@JSON
	@Override
	public String getOrderByCol() {
		if (_orderByCol == null) {
			return StringPool.BLANK;
		}
		else {
			return _orderByCol;
		}
	}

	@Override
	public void setOrderByCol(String orderByCol) {
		_orderByCol = orderByCol;
	}

	@JSON
	@Override
	public String getOrderByType() {
		if (_orderByType == null) {
			return StringPool.BLANK;
		}
		else {
			return _orderByType;
		}
	}

	@Override
	public void setOrderByType(String orderByType) {
		_orderByType = orderByType;
	}

	@JSON
	@Override
	public String getTargetLayoutFriendlyUrl() {
		if (_targetLayoutFriendlyUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _targetLayoutFriendlyUrl;
		}
	}

	@Override
	public void setTargetLayoutFriendlyUrl(String targetLayoutFriendlyUrl) {
		_targetLayoutFriendlyUrl = targetLayoutFriendlyUrl;
	}

	@JSON
	@Override
	public String getTargetPortletId() {
		if (_targetPortletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _targetPortletId;
		}
	}

	@Override
	public void setTargetPortletId(String targetPortletId) {
		_targetPortletId = targetPortletId;
	}

	@JSON
	@Override
	public String getContentField() {
		if (_contentField == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentField;
		}
	}

	@Override
	public void setContentField(String contentField) {
		_contentField = contentField;
	}

	@JSON
	@Override
	public String getFeedFormat() {
		if (_feedFormat == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedFormat;
		}
	}

	@Override
	public void setFeedFormat(String feedFormat) {
		_feedFormat = feedFormat;
	}

	@JSON
	@Override
	public double getFeedVersion() {
		return _feedVersion;
	}

	@Override
	public void setFeedVersion(double feedVersion) {
		_feedVersion = feedVersion;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				JournalFeed.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			JournalFeed.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JournalFeed toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JournalFeed)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JournalFeedImpl journalFeedImpl = new JournalFeedImpl();

		journalFeedImpl.setUuid(getUuid());
		journalFeedImpl.setId(getId());
		journalFeedImpl.setGroupId(getGroupId());
		journalFeedImpl.setCompanyId(getCompanyId());
		journalFeedImpl.setUserId(getUserId());
		journalFeedImpl.setUserName(getUserName());
		journalFeedImpl.setCreateDate(getCreateDate());
		journalFeedImpl.setModifiedDate(getModifiedDate());
		journalFeedImpl.setFeedId(getFeedId());
		journalFeedImpl.setName(getName());
		journalFeedImpl.setDescription(getDescription());
		journalFeedImpl.setStructureId(getStructureId());
		journalFeedImpl.setTemplateId(getTemplateId());
		journalFeedImpl.setRendererTemplateId(getRendererTemplateId());
		journalFeedImpl.setDelta(getDelta());
		journalFeedImpl.setOrderByCol(getOrderByCol());
		journalFeedImpl.setOrderByType(getOrderByType());
		journalFeedImpl.setTargetLayoutFriendlyUrl(getTargetLayoutFriendlyUrl());
		journalFeedImpl.setTargetPortletId(getTargetPortletId());
		journalFeedImpl.setContentField(getContentField());
		journalFeedImpl.setFeedFormat(getFeedFormat());
		journalFeedImpl.setFeedVersion(getFeedVersion());

		journalFeedImpl.resetOriginalValues();

		return journalFeedImpl;
	}

	@Override
	public int compareTo(JournalFeed journalFeed) {
		int value = 0;

		value = getFeedId().compareTo(journalFeed.getFeedId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JournalFeed)) {
			return false;
		}

		JournalFeed journalFeed = (JournalFeed)obj;

		long primaryKey = journalFeed.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		JournalFeedModelImpl journalFeedModelImpl = this;

		journalFeedModelImpl._originalUuid = journalFeedModelImpl._uuid;

		journalFeedModelImpl._originalGroupId = journalFeedModelImpl._groupId;

		journalFeedModelImpl._setOriginalGroupId = false;

		journalFeedModelImpl._originalCompanyId = journalFeedModelImpl._companyId;

		journalFeedModelImpl._setOriginalCompanyId = false;

		journalFeedModelImpl._originalFeedId = journalFeedModelImpl._feedId;

		journalFeedModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalFeed> toCacheModel() {
		JournalFeedCacheModel journalFeedCacheModel = new JournalFeedCacheModel();

		journalFeedCacheModel.uuid = getUuid();

		String uuid = journalFeedCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			journalFeedCacheModel.uuid = null;
		}

		journalFeedCacheModel.id = getId();

		journalFeedCacheModel.groupId = getGroupId();

		journalFeedCacheModel.companyId = getCompanyId();

		journalFeedCacheModel.userId = getUserId();

		journalFeedCacheModel.userName = getUserName();

		String userName = journalFeedCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			journalFeedCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			journalFeedCacheModel.createDate = createDate.getTime();
		}
		else {
			journalFeedCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			journalFeedCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			journalFeedCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		journalFeedCacheModel.feedId = getFeedId();

		String feedId = journalFeedCacheModel.feedId;

		if ((feedId != null) && (feedId.length() == 0)) {
			journalFeedCacheModel.feedId = null;
		}

		journalFeedCacheModel.name = getName();

		String name = journalFeedCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			journalFeedCacheModel.name = null;
		}

		journalFeedCacheModel.description = getDescription();

		String description = journalFeedCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			journalFeedCacheModel.description = null;
		}

		journalFeedCacheModel.structureId = getStructureId();

		String structureId = journalFeedCacheModel.structureId;

		if ((structureId != null) && (structureId.length() == 0)) {
			journalFeedCacheModel.structureId = null;
		}

		journalFeedCacheModel.templateId = getTemplateId();

		String templateId = journalFeedCacheModel.templateId;

		if ((templateId != null) && (templateId.length() == 0)) {
			journalFeedCacheModel.templateId = null;
		}

		journalFeedCacheModel.rendererTemplateId = getRendererTemplateId();

		String rendererTemplateId = journalFeedCacheModel.rendererTemplateId;

		if ((rendererTemplateId != null) && (rendererTemplateId.length() == 0)) {
			journalFeedCacheModel.rendererTemplateId = null;
		}

		journalFeedCacheModel.delta = getDelta();

		journalFeedCacheModel.orderByCol = getOrderByCol();

		String orderByCol = journalFeedCacheModel.orderByCol;

		if ((orderByCol != null) && (orderByCol.length() == 0)) {
			journalFeedCacheModel.orderByCol = null;
		}

		journalFeedCacheModel.orderByType = getOrderByType();

		String orderByType = journalFeedCacheModel.orderByType;

		if ((orderByType != null) && (orderByType.length() == 0)) {
			journalFeedCacheModel.orderByType = null;
		}

		journalFeedCacheModel.targetLayoutFriendlyUrl = getTargetLayoutFriendlyUrl();

		String targetLayoutFriendlyUrl = journalFeedCacheModel.targetLayoutFriendlyUrl;

		if ((targetLayoutFriendlyUrl != null) &&
				(targetLayoutFriendlyUrl.length() == 0)) {
			journalFeedCacheModel.targetLayoutFriendlyUrl = null;
		}

		journalFeedCacheModel.targetPortletId = getTargetPortletId();

		String targetPortletId = journalFeedCacheModel.targetPortletId;

		if ((targetPortletId != null) && (targetPortletId.length() == 0)) {
			journalFeedCacheModel.targetPortletId = null;
		}

		journalFeedCacheModel.contentField = getContentField();

		String contentField = journalFeedCacheModel.contentField;

		if ((contentField != null) && (contentField.length() == 0)) {
			journalFeedCacheModel.contentField = null;
		}

		journalFeedCacheModel.feedFormat = getFeedFormat();

		String feedFormat = journalFeedCacheModel.feedFormat;

		if ((feedFormat != null) && (feedFormat.length() == 0)) {
			journalFeedCacheModel.feedFormat = null;
		}

		journalFeedCacheModel.feedVersion = getFeedVersion();

		return journalFeedCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", feedId=");
		sb.append(getFeedId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", structureId=");
		sb.append(getStructureId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", rendererTemplateId=");
		sb.append(getRendererTemplateId());
		sb.append(", delta=");
		sb.append(getDelta());
		sb.append(", orderByCol=");
		sb.append(getOrderByCol());
		sb.append(", orderByType=");
		sb.append(getOrderByType());
		sb.append(", targetLayoutFriendlyUrl=");
		sb.append(getTargetLayoutFriendlyUrl());
		sb.append(", targetPortletId=");
		sb.append(getTargetPortletId());
		sb.append(", contentField=");
		sb.append(getContentField());
		sb.append(", feedFormat=");
		sb.append(getFeedFormat());
		sb.append(", feedVersion=");
		sb.append(getFeedVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.journal.model.JournalFeed");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedId</column-name><column-value><![CDATA[");
		sb.append(getFeedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structureId</column-name><column-value><![CDATA[");
		sb.append(getStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rendererTemplateId</column-name><column-value><![CDATA[");
		sb.append(getRendererTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delta</column-name><column-value><![CDATA[");
		sb.append(getDelta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderByCol</column-name><column-value><![CDATA[");
		sb.append(getOrderByCol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderByType</column-name><column-value><![CDATA[");
		sb.append(getOrderByType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetLayoutFriendlyUrl</column-name><column-value><![CDATA[");
		sb.append(getTargetLayoutFriendlyUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetPortletId</column-name><column-value><![CDATA[");
		sb.append(getTargetPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentField</column-name><column-value><![CDATA[");
		sb.append(getContentField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedFormat</column-name><column-value><![CDATA[");
		sb.append(getFeedFormat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedVersion</column-name><column-value><![CDATA[");
		sb.append(getFeedVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JournalFeed.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JournalFeed.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _feedId;
	private String _originalFeedId;
	private String _name;
	private String _description;
	private String _structureId;
	private String _templateId;
	private String _rendererTemplateId;
	private int _delta;
	private String _orderByCol;
	private String _orderByType;
	private String _targetLayoutFriendlyUrl;
	private String _targetPortletId;
	private String _contentField;
	private String _feedFormat;
	private double _feedVersion;
	private long _columnBitmask;
	private JournalFeed _escapedModel;
}