package com.codestd.plugin.mybatis.generator.actions;

import com.intellij.database.dataSource.DataSourceManager;
import com.intellij.database.psi.DbDataSource;
import com.intellij.database.psi.DbPsiFacade;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.List;

public class MapperGeneratorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent actionEvent) {
        Project project = actionEvent.getData(PlatformDataKeys.PROJECT);
        if (project != null) {
            DbPsiFacade dbPsiFacade = DbPsiFacade.getInstance(project);
            List<DbDataSource> dbDataSources = dbPsiFacade.getDataSources();
            for (DbDataSource dbDataSource : dbDataSources) {
                System.out.println(dbDataSource.getName());
            }
        }

        VirtualFile[] virtualFiles = actionEvent.getData(PlatformDataKeys.VIRTUAL_FILE_ARRAY);
        for (VirtualFile virtualFile : virtualFiles) {
            System.out.println(virtualFile.getCanonicalPath());
        }


    }
}
