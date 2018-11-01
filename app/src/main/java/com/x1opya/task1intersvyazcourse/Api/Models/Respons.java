package com.x1opya.task1intersvyazcourse.Api.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Respons {
    @SerializedName("incomplete_results")
    public boolean incompleteResults;
    public List<Owner> items = null;
}
