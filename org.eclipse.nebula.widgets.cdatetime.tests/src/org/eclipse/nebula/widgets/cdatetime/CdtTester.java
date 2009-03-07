/****************************************************************************
 * Copyright (c) 2008 Jeremy Dowdall
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jeremy Dowdall <jeremyd@aspencloud.com> - initial API and implementation
 *****************************************************************************/

package org.eclipse.nebula.widgets.cdatetime;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.eclipse.nebula.cwt.v.VButton;
import org.eclipse.nebula.cwt.v.VControl;
import org.eclipse.nebula.cwt.v.VNative;
import org.eclipse.nebula.cwt.v.VPanel;
import org.eclipse.nebula.widgets.cdatetime.CDT.PickerPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class CdtTester {

	private CDateTime cdt;
	private Display display;
	
	public CdtTester(final Composite shell,final int style) {
		shell.getDisplay().syncExec(new Runnable() {
			public void run() {
				display = shell.getDisplay();
				cdt = new CDateTime(shell, style);
			}
		});
	}
	
//	private CdtHelper(CDateTime cdt) {
//		this.cdt = cdt;
//	}
	
//	VPanel picker = (VPanel) cdt.panel.getChildren()[0];
//	VPanel header = (VPanel) picker.getChildren()[0];
//	VPanel body = (VPanel) picker.getChildren()[2];
//	VPanel footer = (VPanel) picker.getChildren()[4];
//	VPanel body1 = (VPanel) body.getChildren()[0];
//	VPanel days = (VPanel) body1.getChildren()[0];
//	VPanel months = (VPanel) body1.getChildren()[1];
//	VPanel years = (VPanel) body1.getChildren()[2];

	private Object tmpObj;

	public VNative<Spinner> getSpinner() {
		return cdt.spinner;
	}
	
	public String getText() {
		display.syncExec(new Runnable() {
			public void run() {
				tmpObj = cdt.getText();
			}
		});
		return (String) tmpObj;
	}
	
	public boolean isOpen() {
		return cdt.isOpen();
	}
	
	public boolean setFocus() {
		return cdt.setFocus();
	}
	
	public VNative<Text> getTextWidget() {
		return cdt.getTextWidget();
	}
	
	public VButton getButton() {
		return cdt.getButtonWidget();
	}

	public void setFormat(final int format) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setFormat(format);
			}
		});
	}

	public void setPattern(final String pattern) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setPattern(pattern);
			}
		});
	}

	public void setSelection(final Date date) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setSelection(date);
			}
		});
	}

	public Calendar getCalendarInstance() {
		display.syncExec(new Runnable() {
			public void run() {
				tmpObj = cdt.getCalendarInstance();
			}
		});
		return (Calendar) tmpObj;
	}

	public Date getTime() {
		display.syncExec(new Runnable() {
			public void run() {
				tmpObj = cdt.getTime();
			}
		});
		return (Date) tmpObj;
	}

	public Date getSelection() {
		display.syncExec(new Runnable() {
			public void run() {
				tmpObj = cdt.getSelection();
			}
		});
		return (Date) tmpObj;
	}

	public CDateTime getCDateTime() {
		return cdt;
	}
	
	public void setLocale(final Locale locale) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setLocale(locale);
			}
		});
	}

	public void setOpen(final boolean open) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setOpen(open);
			}
		});
	}

	public void setOpen(final boolean open, final Runnable callback) {
		display.syncExec(new Runnable() {
			public void run() {
				cdt.setOpen(open, callback);
			}
		});
	}

	public VButton getClearButton() {
		if(cdt.pickerPanel != null) {
			VPanel panel = (VPanel) cdt.pickerPanel.getChildren()[0];
			for(VControl child : panel.getChildren()) {
				if(PickerPart.ClearButton == child.getData(CDT.PickerPart)) {
					return (VButton) child;
				}
			}
		}
		return null;
	}
	
	
	
	public VPanel getPanel() {
		return (VPanel) cdt.getPanel().getChildren()[0];
	}
	
	public VPanel getBodyPanel() {
		return (VPanel) getPanel().getChildren()[2];
	}
	
	public VPanel getHeaderPanel() {
		return (VPanel) getPanel().getChildren()[0];
	}

	public VPanel[] getPickerPanels() {
		return (VPanel[]) getBodyPanel().getChildren();
	}
	
	public VPanel getDaysPanel() {
		return (VPanel) getPickerPanels()[0].getChildren()[0];
	}	
	
	public VPanel getMonthsPanel() {
		return (VPanel) getPickerPanels()[0].getChildren()[1];
	}	
	
	public VPanel getYearsPanel() {
		return (VPanel) getPickerPanels()[0].getChildren()[2];
	}	
	
}
