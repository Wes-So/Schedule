package com.schedule.core.usecase.provider;

import com.schedule.core.entity.Provider;

public interface ProviderDao {
	void create(Provider provider);

	void update(Provider provider);

}
