package com.msi.tough.scheduler.monitor;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RunDeleteOldMeasures implements Job {
	Calendar cal;

	@Override
	public void execute(final JobExecutionContext ctx)
			throws JobExecutionException {
		cal = Calendar.getInstance();
		cal.add(Calendar.MILLISECOND, -1209600000);
		cal.add(Calendar.MILLISECOND,
				cal.getTimeZone().getOffset(cal.getTime().getTime()) * -1);
		// String hql =
		// "select m from com.msi.tough.model.monitor.MeasureBean m where m.timestamp < :date1";
		//
		// Session session = HibernateUtil.newSession();
		// session.beginTransaction();
		//
		// Query sql =session.createQuery(hql).setTimestamp("date1",
		// cal.getTime());
		// List list = sql.list();
		// if(list != null && list.size() > 0){
		// MeasureBean deleteMB = (MeasureBean) list.get(list.size()-1);
		// DimensionGroupBean deleteDGB = deleteMB.getDimensions();
		// Set<DimensionBean> setDB = deleteDGB.getDimensions();
		// String del1 =
		// "delete from com.msi.tough.model.monitor.DimensionBean d where d.dimensionId <= '"+deleteDGB.getId()+"'";
		// String del2 =
		// "delete from com.msi.tough.model.monitor.MeasureBean m where m.id <= '"+deleteMB.getId()+"'";
		// String del3 =
		// "delete from com.msi.tough.model.monitor.DimensionGroupBean d where d.id <= '"+deleteDGB.getId()+"'";
		// Query query = session.createQuery(del1);
		// int num1 = query.executeUpdate();
		// Query query2 = session.createQuery(del2);
		// int num2 = query2.executeUpdate();
		// Query query3 = session.createQuery(del3);
		// int num3 = query3.executeUpdate();
		// //
		// logger.info("Deleted DBs: "+num1+" Deleted MB: "+num2+" Deleted DGB "+num3);
		// }
		// // logger.info("Time "+cal.getTime());
		// session.getTransaction().commit();
		// try {
		// session.close();
		// } catch (final Exception e) {
		// }
	}

}
