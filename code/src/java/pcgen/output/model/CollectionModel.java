/*
 * Copyright 2014-15 (C) Tom Parker <thpr@users.sourceforge.net>
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.output.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pcgen.output.library.ObjectWrapperLibrary;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateSequenceModel;

/**
 * A CollectionModel wraps a Collection into a TemplateSequenceModel
 */
public class CollectionModel implements TemplateSequenceModel
{

	/**
	 * The underlying collection for this CollectionModel
	 */
	private final List<?> list;

	/**
	 * Constructs a new CollectionModel from the given Collection.
	 * 
	 * This constructor is value-semantic in that no changes are made to the
	 * Collection passed into the method and ownership of the passed list is not
	 * transferred to this class. A copy is made in this constructor and stored
	 * in this CollectionModel.
	 * 
	 * @param c
	 *            The underlying Collection for this CollectionModel
	 * @throws IllegalArgumentException
	 *             if the given Collection is null
	 */
	public CollectionModel(Collection<?> c)
	{
		if (c == null)
		{
			throw new IllegalArgumentException("Collection may not be null");
		}
		this.list = new ArrayList<Object>(c);
	}

	/**
	 * @see freemarker.template.TemplateSequenceModel#get(int)
	 */
	@Override
	public TemplateModel get(int index) throws TemplateModelException
	{
		return ObjectWrapperLibrary.getInstance().wrap(list.get(index));
	}

	/**
	 * @see freemarker.template.TemplateSequenceModel#size()
	 */
	@Override
	public int size() throws TemplateModelException
	{
		return list.size();
	}

}
