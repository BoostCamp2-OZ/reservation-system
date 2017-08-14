package connect.oz.reservation.dao;

import connect.oz.reservation.config.RootApplicationContextConfig;
import connect.oz.reservation.file.dao.FileDao;
import connect.oz.reservation.file.domain.FileDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class FileDaoTest {

    @Autowired
    private FileDao fileDao;

    @Test
    public void shouldSelectProductById() {
        Long fileId = 1L;
        FileDomain file= fileDao.selectFileById(fileId);
        Assert.assertNotNull(file);
    }
}
