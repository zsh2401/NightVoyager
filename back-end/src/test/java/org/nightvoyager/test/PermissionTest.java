package org.nightvoyager.test;

import org.junit.Assert;
import org.junit.Test;
import org.nightvoyager.core.security.IPermissionSet;
import org.nightvoyager.core.security.PermissionHelper;

import java.util.HashSet;

public class PermissionTest {
    @Test
    public void getParentTest() {
        String[] parents = PermissionHelper.getParents("nv.system.this.is.not.exist");
        Assert.assertEquals(5, parents.length);
        Assert.assertEquals("nv", parents[0]);
        Assert.assertEquals("nv.system.this", parents[2]);
    }

    @Test
    public void parentAllAllowedTest() {
        IPermissionSet set = new PSet();
        set.add("nv.system.*");
        Assert.assertTrue(PermissionHelper.isAllowed(set, "nv.system.read_state"));
        Assert.assertTrue(PermissionHelper.isAllowed(set, "nv.system.read.state"));
    }

    @Test
    public void superUser() {
        IPermissionSet set = new PSet();
        set.add("*");
        Assert.assertTrue(PermissionHelper.isAllowed(set, "nv.system.read_state"));
        Assert.assertTrue(PermissionHelper.isAllowed(set, "nv.system.read.state"));
    }

    static class PSet extends HashSet<String> implements IPermissionSet {

    }
}
