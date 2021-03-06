/*
 * Copyright 2014, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.androidjunitrunnersample;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import junit.framework.TestSuite;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnitRunner;
import androidx.test.rule.ActivityTestRule;
import org.junit.runner.RunWith;

import static com.example.android.testing.androidjunitrunnersample.HintMatcher.withHint;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 Ui Tests for {@link CalculatorActivity} using the {@link AndroidJUnitRunner}. This class
 * uses the Junit4 syntax for tests.
 *
 * <p> With the new AndroidJUnit runner you can run both JUnit3 and JUnit4 tests in a single test
 * test suite. The {@link AndroidRunnerBuilder} which extends JUnit's {@link
 * AllDefaultPossibilitiesBuilder} will create a single {@link TestSuite} from all tests and run
 * them. </p>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class OperationHintInstrumentationTest {

    private CalculatorActivity mActivity;

    @Rule
    public ActivityTestRule<CalculatorActivity> activityRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Before
    public void setUp() {
        mActivity = activityRule.getActivity();
    }

    @Test
    public void testPreconditions() {
        assertThat(mActivity, notNullValue());
    }


    @Test
    public void testEditText_OperandOneHint() {
        String operandOneHint = mActivity.getString(R.string.type_operand_one_hint);
        onView(withId(R.id.operand_one_edit_text)).check(matches(withHint(operandOneHint)));
    }

    @Test
    public void testEditText_OperandTwoHint() {
        String operandTwoHint = mActivity.getString(R.string.type_operant_two_hint);
        onView(withId(R.id.operand_two_edit_text)).check(matches(withHint(operandTwoHint)));
    }

}
