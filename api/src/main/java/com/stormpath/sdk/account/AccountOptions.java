/*
 * Copyright 2013 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.account;

import com.stormpath.sdk.query.Options;

/**
 * Account-specific options that may be specified when retrieving {@link Account} resources.
 *
 * @since 0.8
 */
public interface AccountOptions<T> extends Options {

    /**
     * Ensures that when retrieving an Account, the Account's parent {@link Account#getDirectory() directory} is also
     * retrieved in the same request.  This enhances performance by leveraging a single request to retrieve multiple
     * related resources you know you will use.
     *
     * @return this instance for method chaining.
     */
    T withDirectory();

    /**
     * Ensures that when retrieving an Account, the Account's owning {@link Account#getTenant()} tenant} is also
     * retrieved in the same request.  This enhances performance by leveraging a single request to retrieve multiple
     * related resources you know you will use.
     *
     * @return this instance for method chaining.
     */
    T withTenant();

    /**
     * Ensures that when retrieving an Account, the Account's assigned {@link Account#getGroups()} groups}
     * are also retrieved in the same request (paginated).  This enhances performance by leveraging a single request
     * to retrieve multiple related resources you know you will use.
     * <p/>
     * If you wish to control pagination parameters (offset and limit) for the
     * returned groups, see the {@link #withGroups(int) withGroups(limit)} or
     * {@link #withGroups(int, int) withGroups(limit,offset)} methods.
     *
     * @return this instance for method chaining.
     */
    T withGroups();

    /**
     * Ensures that when retrieving an Account, the Account's assigned {@link Account#getGroups()} groups} are also
     * retrieved in the same request (paginated), limiting the first page of group results to {@code limit} items.
     * This enhances performance by leveraging a single request to retrieve multiple related resources you know you
     * will use.
     *
     * @param limit the number of results in the Group collection's first page.  Min: 1, Max: 100.
     * @return this instance for method chaining.
     */
    T withGroups(int limit);

    /**
     * Ensures that when retrieving an Account, the Account's assigned {@link Account#getGroups()} groups} are also
     * retrieved in the same request (paginated) , with the first page of Group results starting at the specified
     * {@code offset} index and limiting the number of results to {@code limit} items.  This enhances performance by
     * leveraging a single request to retrieve multiple related resources you know you will use.
     *
     * @param limit  the number of results in the Group collection's first page.  Min: 1, Max: 100.
     * @param offset the starting index of the first Group to retrieve in the overall Group collection's result set.
     * @return this instance for method chaining.
     */
    T withGroups(int limit, int offset);

    /**
     * Ensures that when retrieving an Account, the Account's associated
     * {@link Account#getGroupMemberships() groupMemberships} are also retrieved in the same request (paginated).
     * This enhances performance by leveraging a single request to retrieve multiple related resources you know you
     * will use.
     * <p/>
     * If you wish to control
     * pagination parameters (offset and limit) for the returned groupMemberships, see the
     * {@link #withGroupMemberships(int) withGroupMemberships(limit)} or
     * {@link #withGroupMemberships(int, int) withGroupMemberships(limit,offset)} methods.
     *
     * @return this instance for method chaining.
     */
    T withGroupMemberships();

    /**
     * Ensures that when retrieving an Account, the Account's associated
     * {@link Account#getGroupMemberships()} groupMemberships} are also retrieved in the same request (paginated),
     * limiting the first page of GroupMembership results to {@code limit} items.  This enhances performance by
     * leveraging a single request to retrieve multiple related resources you know you will use.
     *
     * @param limit the number of results in the GroupMembership collection's first page.  Min: 1, Max: 100.
     * @return this instance for method chaining.
     */
    T withGroupMemberships(int limit);

    /**
     * Ensures that when retrieving an Account, the Account's associated
     * {@link Account#getGroupMemberships()} groupMemberships} are also retrieved in the same request (paginated), with
     * the first page of GroupMembership results starting at the specified {@code offset} index and limiting the number
     * of results to {@code limit} items.  This enhances performance by leveraging a single request to retrieve
     * multiple related resources you know you will use.
     *
     * @param limit  the number of results in the GroupMembership collection's first page.  Min: 1, Max: 100.
     * @param offset the starting index of the first GroupMembership to retrieve in the overall GroupMembership
     *               collection's result set.
     * @return this instance for method chaining.
     */
    T withGroupMemberships(int limit, int offset);

}
