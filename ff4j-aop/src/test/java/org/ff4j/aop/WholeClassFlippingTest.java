package org.ff4j.aop;

/*
 * #%L
 * ff4j-aop
 * %%
 * Copyright (C) 2013 - 2015 Ff4J
 * %%
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
 * #L%
 */

import org.ff4j.FF4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-ff4j-aop-test.xml")
public class WholeClassFlippingTest {
    
    @Autowired
    private FF4j ff4j;

    @Autowired
    @Qualifier("whole.english")
    private WholeClassFlipping wholeClassFlipping;

    /**
     * TDD
     */
    @Test
    public void testAOPClass() {
        // Given english mode
        Assert.assertTrue(wholeClassFlipping.hello1().startsWith("Hello"));
        Assert.assertTrue(wholeClassFlipping.hello2().startsWith("Big"));
        // when
        ff4j.enable("language-french");
        // Then
        System.out.println(wholeClassFlipping.hello1());
        Assert.assertTrue(wholeClassFlipping.hello1().startsWith("Francais"));
        Assert.assertTrue(wholeClassFlipping.hello2().startsWith("Tour"));
        
    }


}
