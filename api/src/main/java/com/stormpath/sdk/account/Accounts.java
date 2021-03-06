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

import com.stormpath.sdk.lang.Classes;
import com.stormpath.sdk.query.Criterion;
import com.stormpath.sdk.query.EqualsExpressionFactory;
import com.stormpath.sdk.query.StringExpressionFactory;

/**
 * Static utility/helper methods for working with {@link Account} resources.  Most methods are
 * <a href="http://en.wikipedia.org/wiki/Factory_method_pattern">factory method</a>s used for forming
 * Account-specific <a href="http://en.wikipedia.org/wiki/Fluent_interface">fluent DSL</a> queries. fpr example:
 * <pre>
 * <b>Accounts.where(Accounts.surname()</b>.containsIgnoreCase("Smith")<b>)</b>
 *     .and(<b>Accounts.givenName()</b>.eqIgnoreCase("John"))
 *     .orderBySurname().descending()
 *     .withGroups(10, 10)
 *     .offsetBy(50)
 *     .limitTo(25));
 * </pre>
 * or, if using static imports:
 * <pre>
 * import static com.stormpath.sdk.account.Accounts.*;
 *
 * ...
 *
 * <b>where(surname()</b>.containsIgnoreCase("Smith")<b>)</b>
 *     .and(<b>givenName()</b>.eqIgnoreCase("John"))
 *     .orderBySurname().descending()
 *     .withGroups(10, 10)
 *     .offsetBy(50)
 *     .limitTo(25));
 * </pre>
 *
 * @since 0.8
 */
public final class Accounts {

    /**
     * Returns a new {@link AccountOptions} instance, used to customize how one or more {@link Account}s are retrieved.
     *
     * @return a new {@link AccountOptions} instance, used to customize how one or more {@link Account}s are retrieved.
     */
    public static AccountOptions options() {
        return (AccountOptions) Classes.newInstance("com.stormpath.sdk.impl.account.DefaultAccountOptions");
    }

    /**
     * Returns a new {@link AccountCriteria} instance to use to formulate an Account query.
     * <p/>
     * Note that it is usually more common to use the {@link #where(com.stormpath.sdk.query.Criterion) where} method
     * instead of this one as the {@code where} method usually lends to better readability.  For example:
     * <pre>
     * Accounts.criteria().add(Accounts.email().eqIgnoreCase("foo@bar.com"))...
     * </pre>
     * versus:
     * <pre>
     * Accounts.where(Accounts.email().eqIgnoreCase("foo@bar.com"))...
     * </pre>
     * or when using static imports:
     * <pre>
     * where(email().eqIgnoreCase("foo@bar.com"))...
     * </pre>
     * While all three statements are equivalent, the second and third examples are shorter and probably more readable.
     *
     * @return a new {@link AccountCriteria} instance to use to formulate an Account query.
     */
    public static AccountCriteria criteria() {
        return (AccountCriteria) Classes.newInstance("com.stormpath.sdk.impl.account.DefaultAccountCriteria");
    }

    /**
     * Creates a new {@link AccountCriteria} instance using the specified {@code criterion} as the first query condition.
     *
     * @return a new {@link AccountCriteria} instance using the specified {@code criterion} as the first query condition.
     */
    public static AccountCriteria where(Criterion criterion) {
        return criteria().add(criterion);
    }

    /**
     * Creates a new {@link StringExpressionFactory} instance reflecting the Account {@link Account#getEmail() email}
     * property, to be used to construct an email Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.email()</b>.eqIgnoreCase("john@doe.com");
     * </pre>
     * The above example invokes the returned factory's <code>eqIgnoreCase("john@doe.com")</code> method.  This produces
     * an email-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory emailExpressionFactory = Accounts.email();
     * Criterion emailEqualsJdoe = emailExpressionFactory.eqIgnoreCase("john@doe.com");
     * criteria.add(emailEqualsJdoe);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getEmail() email}-specific {@link StringExpressionFactory} instance, to be used to
     *         construct a criterion when building an {@link AccountCriteria} query.
     */
    public static StringExpressionFactory email() {
        return newStringExpressionFactory("email");
    }

    /**
     * Creates a new {@link StringExpressionFactory} instance reflecting the Account {@link Account#getUsername() username}
     * property, to be used to construct a username Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.username()</b>.startsWithIgnoreCase("foo");
     * </pre>
     * The above example invokes the returned factory's <code>startsWithIgnoreCase("foo")</code> method.  This
     * produces a username-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory usernameExpressionFactory = Accounts.username();
     * Criterion usernameStartsWithFoo = usernameExpressionFactory.startsWithIgnoreCase("foo");
     * criteria.add(usernameStartsWithFoo);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getUsername() username}-specific {@link StringExpressionFactory} instance, to be
     *         used to construct a criterion when building an {@link AccountCriteria} query.
     */
    public static StringExpressionFactory username() {
        return newStringExpressionFactory("username");
    }

    /**
     * Creates a new {@link StringExpressionFactory} instance reflecting the Account {@link Account#getGivenName() givenName}
     * property, to be used to construct a givenName Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.givenName()</b>.startsWithIgnoreCase("Jo");
     * </pre>
     * The above example invokes the returned factory's <code>startsWithIgnore("Jo")</code> method.  This
     * produces a givenName-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory givenNameExpressionFactory = Accounts.givenName();
     * Criterion givenNameStartsWithJo = givenNameExpressionFactory.startsWithIgnoreCase("Jo");
     * criteria.add(givenNameStartsWithJo);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getGivenName() givenName}-specific {@link StringExpressionFactory} instance, to be
     *         used to construct a criterion when building an {@link AccountCriteria} query.
     */
    public static StringExpressionFactory givenName() {
        return newStringExpressionFactory("givenName");
    }

    /**
     * Creates a new {@link StringExpressionFactory} instance reflecting the Account {@link Account#getMiddleName() middleName}
     * property, to be used to construct a middleName Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.middleName()</b>.startsWithIgnoreCase("Jo");
     * </pre>
     * The above example invokes the returned factory's <code>startsWithIgnore("Jo")</code> method.  This
     * produces a middleName-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory middleNameExpressionFactory = Accounts.middleName();
     * Criterion middleNameStartsWithJo = middleNameExpressionFactory.startsWithIgnoreCase("Jo");
     * criteria.add(middleNameStartsWithJo);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getMiddleName() middleName}-specific {@link StringExpressionFactory} instance, to be
     *         used to construct a criterion when building an {@link AccountCriteria} query.
     */
    public static StringExpressionFactory middleName() {
        return newStringExpressionFactory("middleName");
    }

    /**
     * Creates a new {@link StringExpressionFactory} instance reflecting the Account {@link Account#getSurname() surname}
     * property, to be used to construct a surname Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.surname()</b>.startsWithIgnoreCase("Jo");
     * </pre>
     * The above example invokes the returned factory's <code>startsWithIgnore("Jo")</code> method.  This
     * produces a surname-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory surnameExpressionFactory = Accounts.surname();
     * Criterion surnameStartsWithJo = surnameExpressionFactory.startsWithIgnoreCase("Jo");
     * criteria.add(surnameStartsWithJo);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getSurname() surname}-specific {@link StringExpressionFactory} instance, to be
     *         used to construct a criterion when building an {@link AccountCriteria} query.
     */
    public static StringExpressionFactory surname() {
        return newStringExpressionFactory("surname");
    }

    /**
     * Creates a new {@link EqualsExpressionFactory} instance reflecting the Account {@link Account#getStatus() status}
     * property, to be used to construct a status Criterion when building an {@link AccountCriteria} query.  For example:
     * <pre>
     * Accounts.where(<b>Accounts.status()</b>.eq(AccountStatus.ENABLED);
     * </pre>
     * The above example invokes the returned factory's <code>eq()</code> method.  This
     * produces a status-specific {@link Criterion} which is added to the criteria query (via the
     * {@link #where(com.stormpath.sdk.query.Criterion) where} method).  For example, the following code is equivalent:
     * <pre>
     * AccountCriteria criteria = Accounts.criteria();
     * StringExpressionFactory statusExpressionFactory = Accounts.status();
     * Criterion statusEqualsEnabled = statusExpressionFactory.eq(AccountStatus.ENABLED);
     * criteria.add(statusEqualsEnabled);
     * </pre>
     * The first code example is clearly more succinct and readable.
     *
     * @return a new {@link Account#getStatus() status}-specific {@link StringExpressionFactory} instance, to be
     *         used to construct a criterion when building an {@link AccountCriteria} query.
     */
    public static EqualsExpressionFactory status() {
        return newEqualsExpressionFactory("status");
    }

    private static StringExpressionFactory newStringExpressionFactory(String propName) {
        final String FQCN = "com.stormpath.sdk.impl.query.DefaultStringExpressionFactory";
        return (StringExpressionFactory) Classes.newInstance(FQCN, propName);
    }

    private static EqualsExpressionFactory newEqualsExpressionFactory(String propName) {
        final String FQCN = "com.stormpath.sdk.impl.query.DefaultEqualsExpressionFactory";
        return (EqualsExpressionFactory) Classes.newInstance(FQCN, propName);
    }
}
